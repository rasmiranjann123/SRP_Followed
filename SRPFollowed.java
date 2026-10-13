import java.util.ArrayList;
import java.util.List;

class Product{
	
	String name;
	int price;
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

}

class ShoppingCart{
	
	List<Product> productList=new ArrayList<Product>();
	
	public void addProduvt(Product p) {
		productList.add(p);
	}
	
	public List<Product> getProduct(){
		return this.productList;
	}
	
	public int calculateTotalPrice() {
		
		int sum=0;
		for(Product p: productList) {
			sum+=p.price;
		}
		
		return sum;
	}
}

class DiscountCalculator {

    public int calculateDiscount(int total) {
        return total * 10 / 100;
    }
}


class ShoppingCartPrinter{
	
	private ShoppingCart cart;
	private DiscountCalculator calculator;
	
	public ShoppingCartPrinter(ShoppingCart c) {
		this.cart=c;
		calculator=new DiscountCalculator();
	}
	
	public void printInvoice() {
		System.out.println("Shopping Cart Invoice:");
		for(Product p: cart.getProduct()) {
			System.out.println(p.name+":- "+p.price);
		}
		
		int total = cart.calculateTotalPrice();
        int discount = calculator.calculateDiscount(total);
        int finalPrice = total - discount;

        System.out.println("Shopping Cart Invoice:");
        System.out.println("Total Bill: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Bill: " + finalPrice);
	}
}

class ShoppingCartStorage{
	
	public void saveToDatabase() {
		System.out.println("ShoppingCartStorage.saveToDatabase()");
	}
}

public class SRPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart=new ShoppingCart();
		cart.addProduvt(new Product("Mouse", 600));
		cart.addProduvt(new Product("Jeans", 1450));
		
		ShoppingCartPrinter printer=new ShoppingCartPrinter(cart);
		printer.printInvoice();
    }
}
