


public class Bill implements Money {
	int amount;
	public Bill(int amount) {
		this.amount=amount;
	}
	public Bill() {
		this.amount=1;
	}
	public double getAmount() {
		return amount;
	}
	public String toString() {
		return "$"+Integer.toString(this.amount);
	}
}
