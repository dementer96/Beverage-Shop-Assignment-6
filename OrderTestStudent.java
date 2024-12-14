import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTestStudent {

	@Test
    public void testConstructor() {
        Customer customer = new Customer("John", 25);
        Order order = new Order(10, Day.MONDAY, customer);
        assertEquals(10, order.getOrderTime());
        assertEquals(Day.MONDAY, order.getOrderDay());
        assertEquals("John", order.getCustomer().getName());
    }

    @Test
    public void testAddNewBeverage() {
        Order order = new Order(12, Day.FRIDAY, new Customer("Jane", 22));
        order.addNewBeverage("Latte", Size.SMALL, true, false); // Add Coffee
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Coffee);
    }

    @Test
    public void testCalcOrderTotal() {
        Order order = new Order(10, Day.WEDNESDAY, new Customer("John", 30));
        order.addNewBeverage("Smoothie", Size.LARGE, 3, true); // Smoothie
        order.addNewBeverage("Wine", Size.MEDIUM); // Alcohol
        double expectedTotal = 6.0 + 2.5; // Smoothie + Alcohol
        assertEquals(expectedTotal, order.calcOrderTotal(), 0.01);
    }
}
