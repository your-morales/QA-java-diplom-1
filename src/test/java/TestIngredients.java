import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredients {
  Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 228);

  @Test
  public void getNames() {
    assertEquals("sour cream", ingredient.getName());
  }

  @Test
  public void getPrices() {
    Assert.assertEquals(228F, ingredient.getPrice(), 0);
  }

  @Test
  public void getTypes() {
    Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
  }
}
