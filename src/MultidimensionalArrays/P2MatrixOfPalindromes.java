package MultidimensionalArrays;

import java.util.Scanner;

public class P2MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        String[][] palindromeMatrix = new String[r][c];

        fillPalindromeMatrix(palindromeMatrix);

        printMatrix(palindromeMatrix);
    }

    private static void printMatrix(String[][] palindromeMatrix) {
        for (int row = 0; row < palindromeMatrix.length; row++) {
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
                System.out.print(palindromeMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillPalindromeMatrix(String[][] palindromeMatrix) {
        for (int row = 0; row < palindromeMatrix.length; row++) {
            for (int col = 0; col < palindromeMatrix[row].length; col++) {
                char outsideLetter = (char) ('a' + row);
                char middleLetter = (char) ('a' + row + col);
                palindromeMatrix[row][col] = "" + outsideLetter + middleLetter + outsideLetter;
            }
        }
    }
}
