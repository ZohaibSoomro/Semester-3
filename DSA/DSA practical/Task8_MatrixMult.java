import java.util.Arrays;
public class Task8_MatrixMult {
	private static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {
		if (arr1[0].length == arr2.length) {
			int[][] Mul = new int[arr1.length][arr2[0].length];
			for (int i = 0; i < Mul.length; i++)
				for (int j = 0; j < Mul[i].length; j++) {
					int sum = 0;
					for (int k = 0; k < Mul[i].length; k++) {
						sum += arr1[i][k] * arr2[k][j];
					}
					Mul[i][j] = sum;
				}
			return Mul;
		}
		throw new IllegalArgumentException("Multiplication not possible");
	}

	public static void main(String[] args) {
		int[][] array1 = { { 0, 3 }, { 1, 1 } };
		int[][] array2 = { { 2, 1 }, { 3, 2 } };

		int[][] Multipli = matrixMultiplication(array1, array2);
		System.out.println("Array#1: ");
		for (int i = 0; i < Multipli.length; i++)
			System.out.println(Arrays.toString(array1[i]));

		System.out.println("Array#2: ");
		for (int i = 0; i < Multipli.length; i++)
			System.out.println(Arrays.toString(array2[i]));

		System.out.println("Multiplication: ");
		for (int i = 0; i < Multipli.length; i++)
			System.out.println(Arrays.toString(Multipli[i]));
	}
}
