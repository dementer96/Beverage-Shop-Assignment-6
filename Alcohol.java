public class Alcohol extends Beverage {

	private boolean isWeekend;
	
	public static final double WEEKEND_COST = 0.6;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
    public double calcPrice() {
        double price = addSizePrice(); // Base price + size adjustment
        if (isWeekend) {
            price += WEEKEND_COST; // Add cost for weekend
        }
        return price;
    }
	
	public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public String toString() {
        return String.format("%s (Weekend: %b) - Price: %.2f", 
                              super.toString(), isWeekend, calcPrice());
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Alcohol alcohol = (Alcohol) obj;
        return isWeekend == alcohol.isWeekend;
    }

}
