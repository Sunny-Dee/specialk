package specialk;

import com.amazon.speech.ui.SimpleCard;

public interface Recipes {
	public String getRecipeTitle(int index);
	public String getInstructions(int index);
	public String getIngredients(int index);
	
	public String list5Recipes();
	public SimpleCard sendRandomRecipe();
	void addRecipe(Object recipe);
}
