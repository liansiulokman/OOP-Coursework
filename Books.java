abstract public class Books {
    protected String name;
    protected double price;

    /**
     * It is the public constructor for any Book
     * @param name the name of a Book
     * @param price the price of a Book
     */
    public Books(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * This method will increase the price of a book,
     * different categories of Books have different increase rate,
     * this method will be implemented by different categories
     */
    public abstract void increasePrice();

	 /**
     * This method will decrease the price of a book,
     * different categories of Books have different decrease rate,
     * this method will be implemented by different categories
     */
	public abstract void decreasePrice();
	
	 /**
     * This method will try to decrease the price of a book,
     * different categories of Books have different decrease rate,
     * this method will be implemented by different categories
	 * After the method processed, the result decides to perform the decreasePrice() or not
     */
	public abstract boolean testDecreasePrice();
    /**
     * Return the price of this Book
     * @return the price of book
     */
    public double getPrice() {
        return price;
    }
	
}
