import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class TestBurgerParams {
  private final float bunPrice;
  private final float ingredientPrice;
  private final float expectedPrice;

  public TestBurgerParams(float bunPrice, float ingredientPrice, float expectedPrice) {
    this.bunPrice = bunPrice;
    this.ingredientPrice = ingredientPrice;
    this.expectedPrice = expectedPrice;
  }

  @Parameterized.Parameters(name = "Тест данные: {0} {1} {2}")
  public static Object[][] getSumData() {
    return new Object[][]{
            {0F, 0F, 0F},
            {10F, 20F, 40F},
            {10.5F, 20F, 41F},
            {10F, 20.5F, 40.5F},
            {10.55F, 20.55F, 41.65F},
            {10.4F, 20.2F, 41F},
            {100F, 200F, 400F},
            {1000F, 2000F, 4000F},
            {10000F, 20000F, 40000F},
    };
  }

  Bun bun = Mockito.mock(Bun.class);
  Ingredient ingredient = Mockito.mock(Ingredient.class);
  Burger burger = new Burger();

  @Test
  public void testGetPrice() {
    Mockito.when(bun.getPrice()).thenReturn(bunPrice);
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
    System.out.println(burger.getPrice());
    Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
  }
}
