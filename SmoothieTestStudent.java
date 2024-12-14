import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SmoothieTestStudent {

	@Test
    public void testConstructor() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Size.LARGE, smoothie.getSize());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.isAddProtein());
    }

    @Test
    public void testCalcPrice() {
        Smoothie smoothie = new Smoothie("Tropical Delight", Size.MEDIUM, 2, false);
        double expectedPrice = 2.0 + 0.5 * 1 + 0.5 * 2; // Base + size adjustment + fruits
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Green Detox", Size.SMALL, 1, true);
        assertTrue(smoothie.toString().contains("Green Detox"));
        assertTrue(smoothie.toString().contains("SMALL"));
    }
}
