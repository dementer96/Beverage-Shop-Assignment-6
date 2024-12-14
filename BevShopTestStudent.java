import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BevShopTestStudent {

	@Test
    public void testStartNewOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(12, Day.FRIDAY, "John Doe", 25);

        assertEquals(1, shop.totalNumOfMonthlyOrders());
        assertEquals("John Doe", shop.getCurrentOrder().getCustomer().getName());
        assertEquals(Day.FRIDAY, shop.getCurrentOrder().getOrderDay());
    }

    @Test
    public void testProcessCoffeeOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(12, Day.SATURDAY, "Jane Doe", 22);
        shop.processCoffeeOrder("Cappuccino", Size.MEDIUM, true, false);

        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertTrue(shop.getCurrentOrder().getBeverage(0) instanceof Coffee);
        assertEquals("Cappuccino", shop.getCurrentOrder().getBeverage(0).getBevName());
    }

    @Test
    public void testProcessSmoothieOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.WEDNESDAY, "Jane Doe", 20);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertTrue(shop.getCurrentOrder().getBeverage(0) instanceof Smoothie);
        assertEquals("Berry Blast", shop.getCurrentOrder().getBeverage(0).getBevName());
    }

    @Test
    public void testProcessAlcoholOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(15, Day.FRIDAY, "John Doe", 25);
        shop.processAlcoholOrder("Whiskey", Size.SMALL);

        assertEquals(1, shop.getCurrentOrder().getTotalItems());
        assertTrue(shop.getCurrentOrder().getBeverage(0) instanceof Alcohol);
    }

    @Test
    public void testIsValidAge() {
        BevShop shop = new BevShop();
        assertTrue(shop.isValidAge(21));
        assertFalse(shop.isValidAge(20));
    }

    @Test
    public void testTotalMonthlySale() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        shop.processCoffeeOrder("Latte", Size.SMALL, false, false);
        shop.startNewOrder(12, Day.FRIDAY, "Jane Smith", 22);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 3, true);

        double totalSales = shop.totalMonthlySale();
        assertEquals(2.0 + 6.0, totalSales, 0.01);
    }

    @Test
    public void testFindOrder() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        int orderNo = shop.getCurrentOrder().getOrderNo();

        assertEquals(0, shop.findOrder(orderNo));
        assertEquals(-1, shop.findOrder(99999)); // Non-existent order
    }

    @Test
    public void testSortOrders() {
        BevShop shop = new BevShop();
        shop.startNewOrder(10, Day.MONDAY, "John Doe", 25);
        shop.startNewOrder(12, Day.FRIDAY, "Jane Smith", 22);

        int orderNo1 = shop.getOrderAtIndex(0).getOrderNo();
        int orderNo2 = shop.getOrderAtIndex(1).getOrderNo();

        shop.sortOrders();

        assertTrue(shop.getOrderAtIndex(0).getOrderNo() <= shop.getOrderAtIndex(1).getOrderNo());
    }
}
