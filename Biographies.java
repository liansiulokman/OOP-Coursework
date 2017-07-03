// write your Biographies class here

public class Biographies extends NonFiction{
	private String bookName;
	private double bookPrice;
	
	public Biographies(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}