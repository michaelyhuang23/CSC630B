import java.util.*;

public class QuadraticComparator implements Comparator<QuadraticFunction> {
	private double x = 0;

	public QuadraticComparator() {
		super();
	}

	public QuadraticComparator(double x) {
		super();
		this.x = x;
	}

	public int compare(QuadraticFunction a, QuadraticFunction b) {
		if (a.valueAt(this.x) > b.valueAt(this.x))
			return 1;
		if (a.valueAt(this.x) < b.valueAt(this.x))
			return -1;
		return 0;

	}
}
