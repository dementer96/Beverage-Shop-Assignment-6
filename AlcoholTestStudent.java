import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlcoholTestStudent {

	@Test
    public void testConstructor() {
        Alcohol alcohol = new Alcohol("Whiskey", Size.SMALL, true);
        assertEquals("Whiskey", alcohol.getBevName());
        assertEquals(Size.SMALL, alcohol.getSize());
        assertTrue(alcohol.isWeekend());
    }

    @Test
    public void testCalcPrice() {
        Alcohol alcohol = new Alcohol("Vodka", Size.MEDIUM, true);
        double expectedPrice = 2.0 + 0.5 * 1 + 0.6; // Base + size adjustment + weekend cost
        assertEquals(expectedPrice, alcohol.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        Alcohol alcohol = new Alcohol("Rum", Size.LARGE, false);
        assertTrue(alcohol.toString().contains("Rum"));
        assertTrue(alcohol.toString().contains("LARGE"));
    }

}
