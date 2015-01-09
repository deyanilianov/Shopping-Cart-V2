public class Service extends Item {

	private Payment payment;

	public Service(String name, String description, double price,
			Payment payment) {
		super(name, description, price);
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
