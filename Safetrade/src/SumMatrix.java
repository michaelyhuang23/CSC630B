
public class SumMatrix {
	/***
	 * This class tackles the problem presented in JM chapter 19 exercise 5 (page
	 * 459) Author: Michael Huang
	 */

	public int sumCross(int[][] matrix, int row, int col) {
		int sum = 0;
		for (int r = 0; r < matrix.length; r++) {
			sum += matrix[r][col];
		}
		for (int c = 0; c < matrix.length; c++) {
			sum += matrix[row][c];
		}
		sum -= matrix[row][col];
		return sum;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 2, 1 }, { 3, 2, 5 }, { 1, 23, 4 } };
		SumMatrix h = new SumMatrix();
		int s = h.sumCross(matrix, 2, 1);
		System.out.print(s);

	}
}
