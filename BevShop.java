import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private Order currentOrder;
    private int alcoholCount;

    public BevShop() {
        orders = new ArrayList<>();
        alcoholCount = 0;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(currentOrder);
        alcoholCount = 0; // Reset alcohol count for the new order
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            System.out.println("Cannot add more fruits than the maximum allowed.");
        } else {
            currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (!isValidAge(currentOrder.getCustomer().getAge())) {
            System.out.println("Customer does not meet the minimum age requirement for alcohol.");
        } else if (!isEligibleForMore()) {
            System.out.println("You have reached the maximum limit for alcohol beverages.");
        } else {
        	boolean isWeekend = currentOrder.getOrderDay() == Day.SATURDAY || currentOrder.getOrderDay() == Day.SUNDAY;
        	currentOrder.addNewBeverage(bevName, size);
            alcoholCount++;
        }
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public boolean isEligibleForMore() {
        return alcoholCount < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return alcoholCount;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        orders.sort(null); // Uses natural ordering defined in Order's compareTo method
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monthly Orders:\n");
        for (Order order : orders) {
            sb.append(order).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(String.format("%.2f", totalMonthlySale())).append("\n");
        return sb.toString();
    }
    
    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i; // Return the index of the matching order
            }
        }
        return -1; // Return -1 if the order number is not found
    }
    
    @Override
    public Order getCurrentOrder() {
        return currentOrder; // Return the current order being processed
    }
    
    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }
    
    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }
    
    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }
    
    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo); // Use findOrder to locate the order
        if (index != -1) {
            return orders.get(index).calcOrderTotal(); // Calculate total if order is found
        }
        return 0.0; // Return 0.0 if order is not found
    }
    
    
}
