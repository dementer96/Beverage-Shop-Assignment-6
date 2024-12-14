public class Smoothie extends Beverage {
	
	private int numOfFruits;
    private boolean addProtein;
	
    public static final double PROTEIN_COST = 1.5;
    public static final double FRUIT_COST = 0.5;
	
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }
	
    @Override
    public double calcPrice() {
        double price = addSizePrice(); 
        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST; 
        }
        return price;
    }
	
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isAddProtein() {
        return addProtein;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
    
    @Override
    public String toString() {
        return String.format("%s (Fruits: %d, Protein: %b) - Price: %.2f", 
                              super.toString(), numOfFruits, addProtein, calcPrice());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Smoothie smoothie = (Smoothie) obj;
        return numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein;
    }

}
