package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P4MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
//                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
//                          matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
//                          matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                int sum = 0;
                for (int currentRow = row; currentRow < row + 3; currentRow++) {
                    for (int currentColl = col; currentColl < col + 3; currentColl++) {
                        sum += matrix[currentRow][currentColl];
                    }
                }

                if (sum > maxSum) {
                    maxSum = sum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }
        System.out.printf("Sum = %d\n", maxSum);
        printMaxMatrixSum(matrix, rowIndex, colIndex);
    }

    private static void printMaxMatrixSum(int[][] matrix, int rowIndex, int colIndex) {
        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                                .mapToInt(Integer::parseInt)
                                .toArray();
        }
    }
}
