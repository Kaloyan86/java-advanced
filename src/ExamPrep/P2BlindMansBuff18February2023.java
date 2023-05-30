package ExamPrep;

import java.util.Arrays;
import java.util.Scanner;

public class P2BlindMansBuff18February2023 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                                 .mapToInt(Integer::parseInt)
                                 .toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        String[][] playground = new String[r][c];

        int playerRow = -1;
        int playerCol = -1;
        int moves = 0;
        int touches = 0;

        for (int i = 0; i < r; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            playground[i] = row;

            for (int j = 0; j < row.length; j++) {
                if (playground[i][j].equals("B")) {
                    playerRow = i;
                    playerCol = j;
                    playground[i][j] = "-";
                }
            }
        }

        String direction = scanner.nextLine();
        while (!direction.equals("Finish")) {

            // validate direction
            if (isInvalidMove(playground, direction, r, c, playerRow, playerCol)) {
                direction = scanner.nextLine();
                continue;
            }

            switch (direction) {
                case "left":
                        playerCol--;
                    break;
                case "right":
                        playerCol++;
                    break;
                case "up":
                        playerRow--;
                    break;
                case "down":
                        playerRow++;
                    break;
            }
            moves++;

            if (playground[playerRow][playerCol].equals("P")) {
                touches++;
                playground[playerRow][playerCol] = "-";
            }

            if (touches == 3) {
                break;
            }

            direction = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touches, moves);
    }

    // if is out of playground or there is obstacle
    private static boolean isInvalidMove(String[][] playground, String direction, int row, int col,
                                         int playerRow, int playerCol) {

        switch (direction) {
            case "left":
                playerCol--;
                break;
            case "right":
                playerCol++;
                break;
            case "up":
                playerRow--;
                break;
            case "down":
                playerRow++;
                break;
        }

        return
        playerCol < 0 || playerRow < 0 || playerCol >= col || playerRow >= row ||
        playground[playerRow][playerCol].equals("O");
    }
}
