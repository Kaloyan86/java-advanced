package ExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2StickyFingers25June2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Създаваме квадратна матрица
        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];

        // Прочитаме командите -> List<String> (up, down, left or right.)
        List<String> commands = Arrays.stream(scanner.nextLine().split(","))
                                      .collect(Collectors.toList());

        int rowIndex = -1;
        int colIndex = -1;

        // Попълваме матрицата и намираме координатите на крадеца
        for (int r = 0; r < field.length; r++) {
            String[] row = scanner.nextLine().split("\\s+");
            field[r] = row;
            // търсим координатите на крадеца
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c].equals("D")) {
                    rowIndex = r;
                    colIndex = c;
                    field[r][c] = "+";
                }
            }
        }
        int pocket = 0;
        boolean isCaught = false;
        // Итерираме през List с команди и изпълняваме съответната команда
        for (String command : commands) {
            // Ако с текущата команда той излезе извън полето,
            // то той трябва да остане на същата позиция
            // и да се прочете следващата команда
            if (isGoingOutside(command, field, rowIndex, colIndex)) {
                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            }

            switch (command) {
                case "up":
                    rowIndex--;
                    break;
                case "down":
                    rowIndex++;
                    break;
                case "left":
                    colIndex--;
                    break;
                case "right":
                    colIndex++;
                    break;
            }
            if (field[rowIndex][colIndex].equals("$")) {
                // house
                pocket += rowIndex * colIndex;
                field[rowIndex][colIndex] = "+";
                System.out.printf("You successfully stole %d$.\n", rowIndex * colIndex);
            } else if (field[rowIndex][colIndex].equals("P")) {
                // police
                isCaught = true;
                break;
            }
        }
        if (isCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.\n", pocket);
            field[rowIndex][colIndex] = "#";
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.\n", pocket);
            field[rowIndex][colIndex] = "D";
        }
        printMatrix(field);
    }

    private static boolean isGoingOutside(String command, String[][] field, int rowIndex, int colIndex) {

        switch (command) {
            case "up":
                rowIndex--;
                break;
            case "down":
                rowIndex++;
                break;
            case "left":
                colIndex--;
                break;
            case "right":
                colIndex++;
                break;
        }

        return rowIndex < 0 || rowIndex > field.length || colIndex < 0 || colIndex > field.length;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.println(String.join(" ", strings));
        }
    }
}
