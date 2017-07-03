public class NonFiction extends Books {
    /**
     * The constructor of NonFiction, NonFiction is a subclass of Books
     * @param name
     * @param price
     */
    public NonFiction(String name, double price) {
        super(name, price);
    }

    /**
     * This method increases the price of Books which belong to NonFiction category
     */
    public void increasePrice() {
        price = price * 1.3 + Math.pow(price, 0.1);
    }
	
	/**
     * This method decreases the price of Books which belong to NonFiction category
     */
	public void decreasePrice() {
        price = price - price * 0.1 - 10;
    }
	
	/**
     * This method tests to decrease the price of Books which belong to NonFiction category
	 * @return it returns false if the price lower than 0, otherwise return true
     */
	public boolean testDecreasePrice() {
		double test = price - price * 0.1 - 10;
		if(test < 0)
			return false;
		else
			return true;
		
	}
}