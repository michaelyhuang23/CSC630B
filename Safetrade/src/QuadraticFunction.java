import java.util.*;
import java.lang.Math;

public class QuadraticFunction implements Comparable<QuadraticFunction> {
	int a, b, c;

	public QuadraticFunction(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double valueAt(double x) {
		return (a * Math.pow(x, 2) + b * x + c);
	}

	public int compareTo(QuadraticFunction other) {
		int result = 0;
		result = this.a - other.a;
		if (result != 0)
			return result;
		result = this.b - other.b;
		if (result != 0)
			return result;
		result = this.c - other.c;
		return result;

	}

	private String sign(int a) {
		if (a > 0) {
			return "+";
		} else if (a < 0) {
			return "-";
		} else {
			return "0";
		}
	}

	public boolean equals(Object oth) {
		QuadraticFunction other = (QuadraticFunction) (oth);
		return (this.a == other.a && this.b == other.b && this.c == other.c);
	}

	public String toString() {
		String result = "";
		if (a != 0) {
			if (a < 0)
				result += "-";
			if (Math.abs(a) != 1)
				result += Integer.toString(Math.abs(a));
			result += "x";
			result += "^2";
		}
		if (b != 0) {
			if (result.contains("x")) {
				result += sign(b);
			} else if (b < 0) {
				result += "-";
			}
			if (Math.abs(b) != 1)
				result += Integer.toString(Math.abs(b));
			result += "x";
		}
		if (c != 0) {
			if (result.contains("x")) {
				result += sign(c);
			} else if (c < 0) {
				result += "-";
			}
			result += Integer.toString(Math.abs(c));
		}

		return result;

	}

}
