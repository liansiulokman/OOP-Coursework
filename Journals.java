// write your Journals class here
public class Journals extends NonFiction{
	private String bookName;
	private double bookPrice;
	
	public Journals(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}