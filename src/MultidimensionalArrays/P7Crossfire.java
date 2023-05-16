package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P7Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {

            int[] target = Arrays.stream(command.split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

            int targetRow = target[0];
            int targetCol = target[1];
            int radius = target[2];
            // destroying along the rows by the given radius
            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isInside(matrix, row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }
            // destroying along the columns by the given radius
            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isInside(matrix, targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            ArrayList<Integer> toRemove = new ArrayList<>();
            toRemove.add(0);
            for (int row = 0; row < matrix.size(); row++) {
                // by removing all zeros on the row all remaining elements are shifted to the left
                matrix.get(row).removeAll(toRemove);
                // remove the row if there are no elements on it
                if (matrix.get(row).size() == 0) {
                    matrix.remove(row);
                    row--;
                }
            }

            command = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int count = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowList.add(count++);
            }
            matrix.add(rowList);
        }
    }

    private static boolean isInside(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            row.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

}

