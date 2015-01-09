import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ShoppingCart {

	private static Catalog stuffs = new Catalog();
	private static Map<Object, Integer> shoppingCart = new HashMap<>();
	private static Scanner input = new Scanner(System.in);
	private static Scanner input2 = new Scanner(System.in);
	
	private static void showShoppingCart(){
		if(shoppingCart.isEmpty()){
			System.out.println("Shopping cart is empty");
			return;
		}
		System.out.println("----- Shopping Cart -----");
		for (Entry<Object, Integer> entry : shoppingCart.entrySet()) {
		    Object key = entry.getKey();
		    int value = entry.getValue();
		    if(key.getClass() == Product.class){
				Product product = (Product) key;
				System.out.println(value + " x " + product.getName() + " | " + product.getPrice() + " | " + product.getProducer());
			}
			if(key.getClass() == Service.class){
				Service service = (Service) key;
				System.out.println(value + " x " + service.getName() + " | " + service.getPrice() +" | "+ service.getPayment());
			}
		}
		System.out.println("-------------------------");
	}
	
	private static void addToShoppingCart(){
		stuffs.showCatalog();
		int numb = 0;
		int quantity = 0;
		try {
			System.out.print("Please select product/services number: ");
			numb = input.nextInt();
			System.out.print("Please select quantity: ");
			quantity = input.nextInt();
		} catch (InputMismatchException e) {
			input.next();
			System.out.println("Incorrect input!");
			return;
		}
		if(numb >= stuffs.size() || numb < 0){
			System.out.println("There is no such product/service");
			return;
		}
		if(quantity <= 0){
			System.out.println("Incorrect input");
			return;
		}
		if(shoppingCart.containsKey(stuffs.get(numb))){
			int val = shoppingCart.get(stuffs.get(numb));
			val += quantity;
			shoppingCart.put(stuffs.get(numb), val);
		}else{
			shoppingCart.put(stuffs.get(numb), quantity);
		}
	}
	
	private static void deleteFromShoppingCart(){
		showShoppingCart();
		boolean check = false;
		System.out.print("Please select name of the product/services: ");
		String name = input2.nextLine().trim();
		System.out.print("Please select quantity: ");
		int quantity = input.nextInt();
		
		Iterator<Map.Entry<Object,Integer>> iter = shoppingCart.entrySet().iterator();
		while (iter.hasNext()) {
		    Map.Entry<Object,Integer> entry = iter.next();
		    Object key = entry.getKey();
		    if(key.getClass() == Product.class){
		    	
		    	Product product = (Product) key;
		    	if(product.getName().equals(name)){
		    		check = true;
		    		if((quantity <= entry.getValue()) && (quantity > 0)){
			    		int val =  entry.getValue() - quantity;
			    		shoppingCart.put(entry.getKey(), val);
			    		System.out.println(quantity + " pieces of " + product.getName() + " was successfully removed");
		    		}else{
		    			System.out.println("Wrong quantity");
		    		}
		    	}
		    	if(entry.getValue() == 0){
		    		iter.remove();
		    	}
		    }
		    
		    if(key.getClass() == Service.class){
		    	Service service = (Service)key;
		    	if(service.getName().equals(name)){
		    		check = true;
		    		if((quantity <= entry.getValue()) && (quantity > 0)){
			    		int val =  entry.getValue() - quantity;
			    		shoppingCart.put(entry.getKey(), val);
			    		System.out.println(quantity + " pieces of " + service.getName() + " was successfully removed");
		    		}else{
		    			System.out.println("Wrong quantity");
		    		}
		    	}
		    	if(entry.getValue() == 0){
		    		iter.remove();
		    	}
		    }
		}
		if(!check){
	    	System.out.println("Wrong name!");
	    }
	}
	
	private static void menu(){
		System.out.println("********** Menu **********");
		System.out.println("Catalog - shows catalog ");
		System.out.println("Cart - shows shopping cart");
		System.out.println("Add - adds a new item");
		System.out.println("Remove - remove item ");
		System.out.println("Quit");
		System.out.println("**************************");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		menu();
		
		String choice = "";
		do {
			System.out.print("Please select action (Catalog, Cart, Add, Remove, Quit): ");
			choice = input2.nextLine();

			switch (choice) {
			case "Catalog":
				stuffs.showCatalog();
				break;
			case "Cart":
				showShoppingCart();
				break;
			case "Add":
				addToShoppingCart();
				break;
			case "Remove":
				deleteFromShoppingCart();
				break;
			case "Quit":
				System.out.println("Bye!");
				return;
			default:
				System.out.println("Wrong operation");
			}
			System.out.println();
		} while (!choice.equals("Quit"));

	}
	
}
