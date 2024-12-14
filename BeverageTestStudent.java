import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BeverageTestStudent {

	@Test
    public void testConstructor() {
        // Abstract class - test through a subclass like Coffee
        Beverage beverage = new Coffee("Latte", Size.SMALL, true, false);
        assertEquals("Latte", beverage.getBevName());
        assertEquals(Size.SMALL, beverage.getSize());
        assertEquals(Type.COFFEE, beverage.getType());
    }

    @Test
    public void testAddSizePrice() {
        // Abstract class - test through a subclass
        Beverage beverage = new Coffee("Latte", Size.LARGE, false, false);
        double expectedPrice = 2.0 + 2 * 0.5; // Base price + size adjustment
        assertEquals(expectedPrice, beverage.addSizePrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Beverage beverage1 = new Coffee("Latte", Size.MEDIUM, true, false);
        Beverage beverage2 = new Coffee("Latte", Size.MEDIUM, true, false);
        Beverage beverage3 = new Coffee("Cappuccino", Size.MEDIUM, false, false);

        assertTrue(beverage1.equals(beverage2)); // Same attributes
        assertFalse(beverage1.equals(beverage3)); // Different name
    }

    @Test
    public void testToString() {
        Beverage beverage = new Coffee("Espresso", Size.SMALL, false, true);
        String result = beverage.toString();
        assertTrue(result.contains("Espresso"));
        assertTrue(result.contains("SMALL"));
        assertTrue(result.contains("COFFEE"));
    }
}
