import java.util.*;

public class Quarter extends Coin {
	public Quarter() {
		super.amount = 0.25;
	}

	public String toString() {
		return "quarter";
	}

	public static void main(String[] arg) {
		ArrayList<Money> piggyBank = new ArrayList<Money>();
		piggyBank.add(new Quarter());
		piggyBank.add(new Bill(1));
		piggyBank.add(new Nickel());
		piggyBank.add(new Dime());
		piggyBank.add(new Quarter());
		piggyBank.add(new Bill(5));
		System.out.println(piggyBank);
		double amount = 0;
		for (Money item : piggyBank) {
			amount += item.getAmount();
		}
		System.out.printf("total amount is: $%.2f", amount);
	}
}
