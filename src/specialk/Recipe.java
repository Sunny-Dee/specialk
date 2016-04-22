package specialk;

public class Recipe {
	private String title;
	private String instructions;
	private String ingredients;
	
	public Recipe(String title, String instructions, String ingredients){
		this.title = title;
		this.instructions = instructions;
		this.ingredients = ingredients;
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
}
