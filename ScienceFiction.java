// write your ScienceFiction class here
public class ScienceFiction extends Fiction{
	private String bookName;
	private double bookPrice;
	
	public ScienceFiction(String name, double price){
		super(name ,price);
		bookName = name;
		bookPrice = price;
	}
}