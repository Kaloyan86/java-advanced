package ExamPrep;

import java.util.Scanner;

public class P2Bee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];

        int[] coordinates = fillMatrixAndGetCoordinates(field, scanner);
        int beeRow = coordinates[0];
        int beeCol = coordinates[1];

        int pollinatedFlowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            // Обновяваме координатите според командата
            int[] updatedCoordinates = updateBeeCoordinates(command, beeRow, beeCol);
            int newRow = updatedCoordinates[0];
            int newCol = updatedCoordinates[1];

            field[beeRow][beeCol] = ".";
            // Проверка дали пчеличката не е излетяла
            if (isOutOfBounds(n, newRow, newCol)) {
                System.out.println("The bee got lost!");
                break;
            }
            // Обновяваме координатите на пчелата
            beeRow = newRow;
            beeCol = newCol;

            // Проверка на какво е кацнала цвете или бонус
            if (field[beeRow][beeCol].equals("f")) {
                pollinatedFlowers++;
            } else if (field[beeRow][beeCol].equals("O")) {
//                fly()
                updatedCoordinates = updateBeeCoordinates(command, beeRow, beeCol);
                field[beeRow][beeCol] = ".";
                // Обновяваме координатите на пчелата
                beeRow = updatedCoordinates[0];
                beeCol = updatedCoordinates[1];
                if (field[beeRow][beeCol].equals("f")) {
                    pollinatedFlowers++;
                }
            }
            command = scanner.nextLine();
        }
        if (command.equals("End")) {
            field[beeRow][beeCol] = "B";
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n"
            , (5 - pollinatedFlowers));
        }
        printField(field);
    }
    private void fly(){}


    private static int[] updateBeeCoordinates(String command, int beeRow, int beeCol) {
        // "up" -> beeRow--
        // "down" -> beeRow++
        // "left" -> beeCol--
        // "right"-> beeCol++
        int[] coordinates = new int[2];
        switch (command) {
            case "up":
                beeRow--;
                break;
            case "down":
                beeRow++;
                break;
            case "left":
                beeCol--;
                break;
            case "right":
                beeCol++;
                break;
        }
        coordinates[0] = beeRow;
        coordinates[1] = beeCol;
        return coordinates;
    }

    private static boolean isOutOfBounds(int n, int beeRow, int beeCol) {
        return beeRow < 0 || beeCol < 0 || beeRow >= n || beeCol >= n;
    }

    private static void printField(String[][] field) {
        for (String[] row : field) {
            for (String element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

    private static int[] fillMatrixAndGetCoordinates(String[][] field, Scanner scanner) {
        int[] beeCoordinates = new int[2];
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
            for (int col = 0; col < field.length; col++) {
                if (field[row][col].equals("B")) {
                    beeCoordinates[0] = row;
                    beeCoordinates[1] = col;
                }
            }
        }
        return beeCoordinates;
    }
}
