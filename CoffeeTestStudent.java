import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoffeeTestStudent {

	public void testConstructor() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertEquals("Espresso", coffee.getBevName());
        assertEquals(Size.SMALL, coffee.getSize());
        assertTrue(coffee.isExtraShot());
        assertFalse(coffee.isExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        Coffee coffee = new Coffee("Latte", Size.LARGE, true, true);
        double expectedPrice = 2.0 + 1.0 + 0.5 * 2; // Base + extras + size adjustment
        assertEquals(expectedPrice, coffee.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Cappuccino", Size.MEDIUM, false, true);
        assertTrue(coffee.toString().contains("Cappuccino"));
        assertTrue(coffee.toString().contains("MEDIUM"));
    }

}
