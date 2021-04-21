
public class Disk implements Comparable<Disk> {
	/***
	 * This class is built for Question 12 of Java Methods chapter 22
	 * Author: Michael Huang
	 */
	int radius;

	public Disk(int radius) {
		/***
		 * construct a new Disk with the given radius
		 */
		this.radius = radius;
	}

	public int compareTo(Disk other) {
		return radius - other.radius;
	}

	public String toString() {
		return Integer.toString(radius);
	}
}
