package ExamPrep;

import java.util.Scanner;

public class P2PawnWars19Feb2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

        for (int r = 0; r < matrix.length; r++) {
            String[] row = scanner.nextLine().split("");
            for (int c = 0; c < matrix.length; c++) {
                matrix[r] = row;
                if (row[c].equals("w")) {
                    wRow = r;
                    wCol = c;
                } else if (row[c].equals("b")) {
                    bRow = r;
                    bCol = c;
                }
            }
        }

        // Правим ходове доката бялата пешка не е достигнала 0
        // и доката черната не е достигнала 7
        // и докато не са се ударили
        boolean isHit = false;
        while (wRow != 0 && bRow != 7 && !isHit) {
            // ако бялата удари черната
            if (isWhiteHit(wRow, wCol, bRow, bCol)) {
                // TODO
                // Принтираме съответното съобщение
                isHit = true;
            }
            wRow -= 1;
            // ако черната удари бялата
            if (isBlackHit(wRow, wCol, bRow, bCol)) {
                // TODO
                // Принтираме съответното съобщение
                isHit = true;
            }
            bRow += 1;

        }

        if (!isHit){
            // Проверка коя пешка е достигнала края на полето първа
            // тъй като бялата винаги е първа на ход
            // при равен брой ходове до края на полето
            // тя стигне винаги първа затова проверката започва с
            // if(wRow == 0)
            // else ...

        }

    }

    private static boolean isBlackHit(int wRow, int wCol, int bRow, int bCol) {
        return bRow + 1 == wRow && (bCol - 1 == wCol || bCol + 1 == wCol);
    }

    private static boolean isWhiteHit(int wRow, int wCol, int bRow, int bCol) {
        return wRow - 1 == bRow && (wCol - 1 == bCol || wCol + 1 == bCol);
    }
}
