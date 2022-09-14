import org.junit.Test;
import praktikum.Bun;
import org.junit.Assert;


import static org.junit.Assert.assertEquals;

public class TestBun {
    Bun bun = new Bun("buuuun", 1488);

    @Test
    public void testGetName() {
      assertEquals("buuuun", bun.getName());
    }

    @Test
    public void testGetPrice() {
      Assert.assertEquals(1488, bun.getPrice(), 0);
    }
  }

