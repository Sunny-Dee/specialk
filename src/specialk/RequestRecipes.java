package specialk;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class RequestRecipes {
	private ArrayList<String> recipeTitles;
	private Hashtable<String, String> recipes;
	String recipeSource;

	public RequestRecipes(String recipeSource) {
		recipeTitles = new ArrayList<String>();
		recipes = new Hashtable<String, String>();
		this.recipeSource = recipeSource;
	}

	public void parseRecipes() {

		try {
			Document doc = Jsoup.connect(recipeSource).get();

			for (Element div : doc.body().getElementsByClass("kstl-rich-text")) {

				String title = div.getElementsByTag("h3").text().trim();
				String url = "";

				if (!title.isEmpty()) {
					recipeTitles.add(title);
					url = parseURL(div.getElementsByTag("a").outerHtml());
					recipes.put(title, url);
				} else if (!(title = div.getElementsByTag("h4").text().trim()).isEmpty()) {
					recipeTitles.add(title);
					url = parseURL(div.getElementsByTag("a").outerHtml());
					recipes.put(title, url);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getRecipeTitles() {
		String allRecipes = "";

		Set<String> titles = recipes.keySet();
		for (String recipe : titles)
			allRecipes += recipe + "\n";
		return allRecipes;
	}

	public String parseURL(String htmlElement) {
		int sourceEnd = recipeSource.indexOf(".com") + 4;
		int start = htmlElement.indexOf("=\"") + 2;
		int end = htmlElement.indexOf(">") - 1;
		String url = recipeSource.substring(0, sourceEnd) + htmlElement.substring(start, end);
		return url;
	}

	public String readRecipesFromTextFile() {
		File f = new File(".");
		StringBuilder answer = new StringBuilder();
		
		try {
			String path = f.getCanonicalPath();
			path += "/recipes.txt";
			System.out.println(path);
			FileReader in = new FileReader(path);
			BufferedReader textReader = new BufferedReader(in);
			
			String temp;
			while ((temp = textReader.readLine()) != null){
				answer.append(temp);
				answer.append("\n");
			}
			
			
			textReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return answer.toString();

	}
	

//	public static void main(String[] args) throws Exception {
//
//		RequestRecipes request = new RequestRecipes("https://www.specialk.com/en_US/recipes.html");
//
//		request.parseRecipes();
//		System.out.println(request.getRecipeTitles());
//		
//		System.out.println(request.readRecipesFromTextFile());
//
//	}
}
