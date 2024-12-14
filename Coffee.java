public class Coffee extends Beverage {
	
	private boolean extraShot;
    private boolean extraSyrup;
    
    public static final double EXTRA_SHOT_PRICE = 0.5;
    public static final double EXTRA_SYRUP_PRICE = 0.5;
	
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }
	
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
            price += EXTRA_SHOT_PRICE;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
        }
        return price;
    }
	
    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
	
    @Override
    public String toString() {
        return String.format("%s (Extra Shot: %b, Extra Syrup: %b) - Price: %.2f", 
                              super.toString(), extraShot, extraSyrup, calcPrice());
    }
	
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Coffee coffee = (Coffee) obj;
        return extraShot == coffee.extraShot && extraSyrup == coffee.extraSyrup;
    }

}
