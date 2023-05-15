package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P3DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        fillMatrix(matrix, scanner);

        int primarySum = getPrimaryDiagonalSum(matrix);

        int secondarySum = getSecondaryDiagonalSum(matrix);

        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {
        int secondarySum = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            secondarySum += matrix[row][matrix.length - 1 - row];
        }
        return secondarySum;
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {
        int primarySum = 0;
        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];
        }
        return primarySum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        }
    }
}
