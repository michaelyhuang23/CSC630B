import java.util.*;

class history {
	public static void mian(String[] args) {
	}
}

public class Tester implements Comparable<Tester> {
	private int number;
	public String name;

	public Tester(int n, String name) {
		number = n;
		this.name = name;
	}

	public static void main(String[] args) {
		Tester test1 = new Tester(72, "mm");
		Tester test2 = new Tester(72, "kk");
		Tester test3 = new Tester(75, "ll");
		Set<Tester> set = new TreeSet<Tester>();
		set.add(test1);
		set.add(test2);
		set.add(test3);
		System.out.println(set);
	}

	@Override
	public int compareTo(Tester o) {
		// TODO Auto-generated method stub
		return number - o.number;
	}

	public String toString() {
		return name;
	}

	public boolean equals(Object o) {
		return name.equals(((Tester) o).name);
	}

}
