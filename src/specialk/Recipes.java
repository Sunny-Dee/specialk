package specialk;

import specialk.ui.StandardCard;

public interface Recipes {
	public String getRecipeTitle(int index);
	public String getInstructions(int index);
	public String getIngredients(int index);
	
	public String list5Recipes();
	public StandardCard sendRandomRecipe();
	void addRecipe(Object recipe);
}
