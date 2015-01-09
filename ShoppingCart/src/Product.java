import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product extends Item {

	private String producer;
	private String date;

	public Product(String name, String description, double price,
			String producer, String date) {
		super(name, description, price);
		this.producer = producer;
		this.date = date;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
