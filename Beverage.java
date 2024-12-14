public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	
	public static final double BASE_PRICE = 2.0;
	public static final double SIZE_PRICE = 0.5;
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	public double addSizePrice() {
		switch (size) {
		case MEDIUM:
			return BASE_PRICE + SIZE_PRICE;
		case LARGE:
			return BASE_PRICE + 2 * SIZE_PRICE;
		default:
			return BASE_PRICE;
		}
	}
	
	public abstract double calcPrice();
	
	public String getBevName() {
		return bevName;
	}
	
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s) - %s", bevName, size, type);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Beverage beverage = (Beverage) obj;
		return bevName.equals(beverage.bevName) &&
				type == beverage.type && 
				size == beverage.size;
	}
	
	
	
	
	
	
}
