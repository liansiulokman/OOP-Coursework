public class Fiction extends Books {
    /**
     * The constructor of Fiction, Fiction is a subclass of Books
     * @param name
     * @param price
     */
    public Fiction(String name, double price) {
        super(name, price);
    }

    /**
     * This method increases the price of Books which belong to Fiction category
     */
    public void increasePrice() {
        price = price * 1.2 + Math.pow(price, 0.2);
    }
	
	 /**
     * This method decreases the price of Books which belong to Fiction category
     */
	public void decreasePrice() {
        price = price - price * 0.2 - 15;
    }
	
	 /**
     * This method tests to decrease the price of Books which belong to Fiction category
	 * @return it returns false if the price lower than 0, otherwise return true
     */
	public boolean testDecreasePrice() {
		double test = price - price * 0.2 - 15;
		if(test < 0)
			return false;
		else
			return true;
		
	}
}
