import java.util.*;

public class SortTest implements Comparator<Integer> {
	private int divisor;

	public SortTest(int k) {
		divisor = k;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int k = input.nextInt();
		Integer[] array = new Integer[N];
		for (int i = 0; i < array.length; i++)
			array[i] = input.nextInt();
		input.close();
		Arrays.parallelSort(array, new SortTest(k));
		System.out.println(Arrays.toString(array));
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1 % divisor - o2 % divisor;
	}
}
