import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;
    
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNo = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        this.beverages = new ArrayList<>();
    }
    
    private int generateOrderNumber() {
        Random rand = new Random();
        return rand.nextInt(80000) + 10000; 
    }
    
    // Add a basic beverage to the order
    public void addNewBeverage(String bevName, Size size) {
    	beverages.add(new Alcohol(bevName, size, isWeekend()));
    }
    
    // Add a coffee beverage to the order
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }
    
    // Add a smoothie beverage to the order
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }
    
    // Calculate total order price
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }
    
    // Count beverages of a specific type
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }
    
    // Get beverage at a specific index
    public Beverage getBeverage(int index) {
        if (index >= 0 && index < beverages.size()) {
            return beverages.get(index);
        }
        return null;
    }
    
    public int getTotalItems() {
        return beverages.size();
    }
    
    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNo).append("\n")
          .append("Time: ").append(orderTime).append("\n")
          .append("Day: ").append(orderDay).append("\n")
          .append("Customer: ").append(customer).append("\n")
          .append("Beverages:\n");
        for (Beverage bev : beverages) {
            sb.append("  ").append(bev).append("\n");
        }
        sb.append("Total Price: ").append(String.format("%.2f", calcOrderTotal())).append("\n");
        return sb.toString();
    }
    
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }
    
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }
}
