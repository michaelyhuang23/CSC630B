
public class TestBooleanHasher {
	public static void main(String[] args) {
		boolean[][] a = new boolean[15][5];
		a[1][3] = true;
		a[12][4] = true;
		a[9][1] = true;
		a[0][0] = true;
		a[1][1] = true;
		System.out.println(a.hashCode() % 8389711);
	}
}
