package specialk;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import specialk.ui.Image;
import specialk.ui.StandardCard;

public class TextRecipes implements Recipes{
	
	ArrayList<Recipe> recipeList;
	
	public TextRecipes(){
		recipeList = new ArrayList<Recipe>();
		addAllRecipes();
	}

	public String getRecipeTitle(int index) {
		return recipeList.get(index).getTitle();
	}

	public String getInstructions(int index) {
		return recipeList.get(index).getInstructions();
	}

	public String getIngredients(int index) {
		return recipeList.get(index).getTitle();
	}

	public String list5Recipes() {
		StringBuilder titles = new StringBuilder();
		int index = recipeList.size();
		
		if (index == 0) return "No recipes in database"; 
		
		if (index > 5) index = 5;

		for (int i = 0; i <= index; i++){
			titles.append(recipeList.get(i).getTitle());
			titles.append("\n");
		}
		
		return titles.toString();
	}

	@Override
	public StandardCard sendRandomRecipe() {
		int index = ThreadLocalRandom.current().nextInt(0, recipeList.size() + 1);
		Recipe recipe = recipeList.get(index);
		
		//Build card contents
		StringBuilder cardContent = new StringBuilder();
		
		cardContent.append("Ingredients\n" + recipe.getIngredients() + "\n \r\n");
		cardContent.append("\r\nInstructions\n" +  recipe.getInstructions());

		//Create the image
		Image image = new Image();
//		image.setSmallImageUrl("https://s3.amazonaws.com/spk-alexa.resources/img/specialk-logo/Special-K-logo-logotype-720x480.png");
//		image.setLargeImageUrl("https://s3.amazonaws.com/spk-alexa.resources/img/specialk-logo/Special-K-logo-logotype-1024x768.png");
		image.setLargeImageUrl(recipe.getPicture());
		image.setSmallImageUrl(recipe.getPicture());
		
		StandardCard imageCard = new StandardCard(); 
		imageCard.setImage(image);
		imageCard.setTitle(recipe.getTitle());
		imageCard.setText(cardContent.toString());
		
		
		return imageCard;
	}

	public void addRecipe(Object recipe) {
		recipeList.add((Recipe) recipe);
		
	}
	
	private void addAllRecipes(){
		recipeList.add(new Recipe(
					"Gluten-Free Pumpkin Spice Latte",
					"1. In serving bowl combine KELLOGG’S SPECIAL K Cereal Gluten Free " +
					"Touch of Brown Sugar and milk.\n" +
					"2. Drizzle with pumpkin latte syrup. Sprinkle with espresso powder. Serve immediately.",
					
					"1 cup Kellogg’s Special K Cereal Gluten Free Touch of Brown Sugar\n" + 
					"1/2 cup fat-free milk or 1% milk\n" + 
					"1 tablespoon pumpkin latte syrup or pumpkin beverage syrup\n" +
					"1/8 to 1/4 teaspoon instant espresso coffee powder or instant coffee granules",
					"https://s3.amazonaws.com/spk-alexa.resources/img/recipe-img/pumpkin_spice_latte.jpg"));
		
		recipeList.add(new Recipe(
					"Southwestern Breakfast Burrito Bowl",
					
					"1. Preheat broiler. In small bowl whisk egg.\n" + 
					"2. In 8-inch, oven-safe skillet melt butter. Pour in egg. " + 
					"Cook over medium heat, without stirring, until mixture begins to set on the " + 
					"bottom and around edges. Using spatula, lift and fold egg mixture, allowing " + 
					"uncooked portion to flow underneath. Continue cooking over medium heat for 2 " +
					"to 3 minutes or until egg is cooked through. Remove from heat.\n" +
					"3. Sprinkle cheese on top of egg. Broil 4- to 5-inches from the heat for 1 to " + 
					"2 minutes or until cheese melts. \n4. Pour KELLOGG’S SPECIAL K Cereal Protein " + 
					"into serving bowl. Top with egg mixture, salsa, beans and cherry tomato. Serve immediately.",
					
					"1 egg, slightly beaten\n1 teaspoon butter\n" + 
					"2 tablespoons shredded cheddar cheese" + 
					"1 cup Kellogg’s Special K Cereal Protein, coarsely crushed\n" + 
					"2 tablespoons salsa verde or other salsa\n" + 
					"2 tablespoons canned black beans, rinsed and drained\n" +
					"1 cherry tomato or grape tomato, halved",
					"https://s3.amazonaws.com/spk-alexa.resources/img/recipe-img/southwestern_breakfast_burrito_bowl.jpg"));
		
		recipeList.add(new Recipe(
				"Special K French Toast",
				"1. In 2-cup, microwave-safe bowl lightly beat together egg, milk and vanilla. " + 
				"Stir in KELLOGG’S SPECIAL K Cereal Original. Microwave at high for 45 seconds " + 
				"to 1 1/2 minutes or until knife inserted into center comes out clean. Slide " + 
				"onto serving plate, if desired.\n" + 
				"2. Slice banana on top of cereal mixture. Drizzle with syrup. Serve immediately.",
				
				"1 egg, slightly beaten\n2 tablespoons milk\n" +
				"1/2 teaspoon vanilla\n1 cup Kellogg’s Special K Cereal Original\n" +
				"1/2 small ripe banana, sliced\n"
				+ "2 tablespoons sugar-free maple-flavored syrup or maple syrup\n" + 
				"Microwave cooking times may vary.", 
				"https://s3.amazonaws.com/spk-alexa.resources/img/recipe-img/french_toast.jpg"));
		
		recipeList.add(new Recipe(
				"Cherry Cobbler a la Kellogg’s Special K",
				"1. Thaw cherries, if frozen. Halve and pit cherries.\n" + 
				"2. In serving bowl combine cherries, KELLOGG’S SPECIAL K Cereal " +
				"Original and almond milk.\n3. Sprinkle brown sugar over cereal mixture. " +
				"Crumble KELLOGG’S SPECIAL K Pastry Crisp Brown Sugar Cinnamon over top. " +
				"Serve immediately.\nTip: For a fresh-from-the-oven-cobbler feel, warm "
				+ "the cherries in the microwave. Just place them in a microwave-safe bowl. " +
				"Microwave at high for 30 to 60 seconds or until heated through. Continue as directed above.",
				"1/2 cup fresh or frozen sweet cherries\n" +
				"1/2 cup vanilla almond milk\n" +
				"1 cup Kellogg’s Special K Cereal Original\n" +
				"1 teaspoon brown sugar \n" +
				"1 Kellogg’s Special K Pastry Crisps Brown Sugar Cinnamon",
				"https://s3.amazonaws.com/spk-alexa.resources/img/recipe-img/cherry_cobbler.jpg"));
		
		recipeList.add(new Recipe(
				"Honey-Hot Cocoa Kellogg’s Special K Shooters",
				"1. In small bowl whisk coconut milk until smooth. Whisk in cocoa powder, " + 
				"honey and cayenne pepper. Refrigerate for 2 to 24 hours in airtight container.\n" +
				"2. Before serving, place KELLOGG’S SPECIAL K Cereal Original into six " + 
				"2-ounce glasses (shot glasses). Pour chocolate mixture over top of each. " + 
				"Sprinkle with coconut.",
				"1/4 cup canned unsweetened coconut milk (not light)\n" +
				"2 tablespoons unsweetened cocoa powder \n" +
				"2 tablespoons honey\n" +
				"1/8 teaspoon cayenne pepper \n" +
				"1 cup Kellogg’s Special K Cereal Original\n" +
				"1 tablespoon raw coconut chips or unsweetened coconut flakes",
				"https://s3.amazonaws.com/spk-alexa.resources/img/recipe-img/shooters.jpg"));
		
		
		recipeList.add(new Recipe( "Kickn’ Crunch",
				"Place KELLOGG’S SPECIAL K Cereal Protein in serving bowl. "+
				"Top with yogurt and avocado. Sprinkle with cayenne pepper.",
				"1/2 cup Kellogg’s Special K Cereal Protein\n" +
				"1/4 cup plain low-fat yogurt\n" +
				"2 tablespoons chopped fresh avocado\n" +
				"1/8 teaspoon ground cayenne pepper",
				"https://s3.amazonaws.com/spk-alexa.resources/img/recipe-img/kickin_crunch_recipe_pim.jpg"));
	}
	
//	public static void main(String args[]){
//		TextRecipes test = new TextRecipes();
//		SimpleCard card = test.sendRandomRecipe();
//		System.out.print("Card content\n" + card.getContent());
//	}

}
