// write your Mystery class here
public class Mystery extends Fiction{
	private String bookName;
	private double bookPrice;
	
	public Mystery(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}