package entities;
public class UsedProduct extends Product {
	private String manufactureDate;

	public UsedProduct() {
		super();
	}
  
	public UsedProduct(String name, Double price, String manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}
	
	public String priceTag() {
		return this.getName() + "(used)" + "$" + this.getPrice() + "(Manufacture date: " + this.manufactureDate + ")";
	}
}
