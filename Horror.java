// write your Horror class here
public class Horror extends Fiction{
	private String bookName;
	private double bookPrice;
	
	public Horror(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}