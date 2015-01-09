import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.Size;


public class Catalog {
	private static List<Object> stuffs;
	
	public Catalog() {
		stuffs = new ArrayList<Object>();
		Product tv = new Product("TV", "32 inch, HD", 450, "Philips", "25-01-2014");
		Product pc = new Product("PC", "Core i5", 1000, "HP", "18-02-2013");
		Product table = new Product("Table", "Just a table", 100, "Unknown", "05-07-2011");
		Service transport = new Service("transport", "transport", 20, Payment.FIXED_AMOUNT);
		Service maintenance = new Service("maintenance", "maintenance", 5, Payment.PER_HOUR);

		stuffs.add(tv);
		stuffs.add(pc);
		stuffs.add(table);
		stuffs.add(transport);
		stuffs.add(maintenance);
	}
	
	public  void showCatalog(){
		System.out.println("----- Catalog -----");
		for (int i = 0; i < stuffs.size(); i++) {
			if(stuffs.get(i).getClass() == Product.class){
				Product product = (Product) stuffs.get(i);
				System.out.println(i + ". " + product.getName() + " | " + product.getPrice() + " | " + product.getProducer());
			}
			if(stuffs.get(i).getClass() == Service.class){
				Service service = (Service) stuffs.get(i);
				System.out.println(i + ". " + service.getName() + " | " + service.getPrice() + " | " + service.getPayment());
			}
		}
		System.out.println("-------------------");
	}
	
	public int size() {
		return stuffs.size();
	}
	
	public Object get(int i) {
		return  stuffs.get(i);
	}
}
