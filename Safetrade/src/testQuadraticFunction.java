
import java.util.Scanner;

public class testQuadraticFunction {
	public static void main(String[] arg) {
		Scanner input = new Scanner(System.in);
		QuadraticFunction f1 = new QuadraticFunction(5, 1, -3);
		QuadraticFunction f2 = new QuadraticFunction(1, 0, 3);
		QuadraticFunction f3 = new QuadraticFunction(5, 1, -3);
		QuadraticFunction f4 = new QuadraticFunction(-8, 0, 0);
		System.out.println("Output from the run of testQuadraticFunction.java Author: Michael Huang");
		System.out.println("Author: Michael Huang");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.printf("\n\n Enter x value: ");
		double xVal = input.nextDouble();
		System.out.printf("\n f1 value at %.1f is %.1f", xVal, f1.valueAt(xVal));
		System.out.printf("\n f2 value at %.1f is %.1f", xVal, f2.valueAt(xVal));
		System.out.printf("\n f3 value at %.1f is %.1f", xVal, f3.valueAt(xVal));
		System.out.printf("\n f4 value at %.1f is %.1f\n", xVal, f4.valueAt(xVal));
		System.out.println("f1.equals(f2): " + f1.equals(f2));
		System.out.println("f1.equals(f3): " + f1.equals(f3));
		System.out.println("f1.compareTo(f2) (in order of coefficient a,b,c): " + f1.compareTo(f2));
		System.out.println("f2.compareTo(f3) (in order of coefficient a,b,c): " + f2.compareTo(f3));
		System.out.println("f3.compareTo(f1) (in order of coefficient a,b,c):  " + f3.compareTo(f1));
		QuadraticComparator comparer1 = new QuadraticComparator(0);
		System.out.println("Comparing f1(0) to f2(0): " + comparer1.compare(f1, f2));
		System.out.println("Comparing f1(0) to f3(0): " + comparer1.compare(f1, f3));
		System.out.println("Comparing f2(0) to f1(0): " + comparer1.compare(f2, f1));
		QuadraticComparator comparer2 = new QuadraticComparator(xVal);
		System.out.println("Comparing f1(x) to f2(x) at " + "x=" + xVal + " :" + comparer2.compare(f1, f2));
		System.out.println("Comparing f1(x) to f3(x) at " + "x=" + xVal + " :" + comparer2.compare(f1, f3));
		System.out.println("Comparing f2(x) to f1(x) at " + "x=" + xVal + " :" + comparer2.compare(f2, f1));
		input.close();
	}
}
