// write your Romance class here
public class Romance extends Fiction{
	private String bookName;
	private double bookPrice;
	
	public Romance(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}