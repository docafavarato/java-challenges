import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class app {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.print("Common, used or imported? (c/u/i): ");
			char typeBool = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (typeBool == 'i') {
				System.out.print("Custom fee: ");
				Double customFee = sc.nextDouble();
				ImportedProduct product = new ImportedProduct(name, price, customFee);
				products.add(product);
			} else if (typeBool == 'c') {
				Product product = new Product(name, price);
				products.add(product);
			} else if (typeBool == 'u') {
				System.out.print("Manufacture date: ");
				String manufactureDate = sc.next();
				UsedProduct product = new UsedProduct(name, price, manufactureDate);
				products.add(product);
			}
		}
		
		System.out.println("PRICE TAGS: ");
		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}
} 
