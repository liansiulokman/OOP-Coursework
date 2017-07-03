// write your History class here
public class History extends NonFiction{
	private String bookName;
	private double bookPrice;
	
	public History(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}