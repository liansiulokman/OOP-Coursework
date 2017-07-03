// write your Travel class here
public class Travel extends NonFiction{
	private String bookName;
	private double bookPrice;
	
	public Travel(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}