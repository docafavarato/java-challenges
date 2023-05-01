package entities;
public class ImportedProduct extends Product {
	private Double customsFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public String priceTag() {
		return this.getName() + "$" + this.getPrice() + " - Custom fee: " + this.customsFee;
	}
	
	public Double totalPrice() {
		return this.getPrice() + this.customsFee;
	}
}
