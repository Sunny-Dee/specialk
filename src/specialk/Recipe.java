package specialk;

public class Recipe {
	private String title;
	private String instructions;
	private String ingredients;
	private String picture;
	
	public Recipe(String title, String instructions, String ingredients, String picture){
		this.title = title;
		this.instructions = instructions;
		this.ingredients = ingredients;
		this.picture = picture;
	}
	
	public String getTitle(){
		return title;
	}
	public String getInstructions(){
		return instructions;
		
	}
	public String getIngredients(){
		return ingredients;
		
	}
	
	public String getPicture(){
		return picture;
		
	}
}
