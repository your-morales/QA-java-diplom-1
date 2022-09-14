import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {

  @Mock
  Bun bun;

  @Mock
  Ingredient ingredient, ingredient1;

  Burger burger = new Burger();

  @Test
  public void setBun() {
    burger.setBuns(bun);
    Assert.assertEquals(bun, burger.bun);
  }

  @Test
  public void addIngredient() {
    burger.addIngredient(ingredient);
    Assert.assertEquals(1, burger.ingredients.size());
  }

  @Test
  public void removeIngredient() {
    burger.addIngredient(ingredient);
    burger.removeIngredient(0);
    Assert.assertEquals(0, burger.ingredients.size());
  }

  @Test
  public void moveIngredient() {
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient);
    burger.moveIngredient(0, 1);
    Assert.assertEquals(1, burger.ingredients.lastIndexOf(ingredient));
  }

  @Test
  public void getReceipt() {
    Mockito.when(bun.getName()).thenReturn("white bun");
    Mockito.when(bun.getPrice()).thenReturn(50F);
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
    Mockito.when(ingredient.getName()).thenReturn("cutlet");
    Mockito.when(ingredient.getPrice()).thenReturn(100F);
    burger.addIngredient(ingredient1);
    Mockito.when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
    Mockito.when(ingredient1.getName()).thenReturn("chili sauce");
    Mockito.when(ingredient1.getPrice()).thenReturn(110F);
    StringBuilder receiptExpected = new StringBuilder(String.format("(==== white bun ====)%n"));
    receiptExpected.append(String.format("= filling cutlet =%n"));
    receiptExpected.append(String.format("= sauce chili sauce =%n"));
    receiptExpected.append(String.format("(==== white bun ====)%n"));
    receiptExpected.append(String.format("%n"));
    receiptExpected.append(String.format("Price: 310,000000%n"));
    Assert.assertEquals(receiptExpected.toString(), burger.getReceipt());
    Assert.assertEquals(110, burger.getReceipt().length());
  }
}

