package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PawnWars {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            char[][] matrix = new char[8][8];
            for (int i = 0; i < 8; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int whiteRow = -1;
            int whiteColumn = -1;
            int blackRow = -1;
            int blackColumn = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (matrix[i][j] == 'w') {
                        whiteRow = i;
                        whiteColumn = j;
                    } else if (matrix[i][j] == 'b') {
                        blackRow = 8 - (i + 1);
                        blackColumn = j;
                    }
                }
            }
            char letter;
            while (whiteRow > 0 && blackRow > 0) {
                if (whiteColumn - 1 >= 0) {
                    if ((matrix[whiteRow - 1][whiteColumn - 1] == 'b')) {
                        letter = getLetter(blackColumn);
                        System.out.println("Game over! White capture on " + letter + (blackRow + 1) + ".");
                        return;
                    }
                }
                if (whiteColumn + 1 < 8) {
                    if (matrix[whiteRow - 1][whiteColumn + 1] == 'b') {
                        letter = getLetter(blackColumn);
                        System.out.println("Game over! White capture on " + letter + (blackRow + 1) + ".");
                        return;
                    }
                }
                matrix[whiteRow--][whiteColumn] = '-';
                matrix[whiteRow][whiteColumn] = 'w';
                if (whiteRow == 0) {
                    break;
                }
                if (8 - blackRow > 0) {
                    if (blackColumn - 1 >= 0) {
                        if (matrix[8 - blackRow][blackColumn - 1] == 'w') {
                            letter = getLetter(whiteColumn);
                            System.out.println("Game over! Black capture on " + letter + (whiteRow + 2) + ".");
                            return;
                        }
                    }
                    if (blackColumn + 1 < 8) {
                        if (matrix[8 - blackRow][blackColumn + 1] == 'w') {
                            letter = getLetter(whiteColumn);
                            System.out.println("Game over! Black capture on " + letter + (whiteRow + 2) + ".");
                            return;
                        }
                    }
                }
                matrix[7 - blackRow--][blackColumn] = '-';
                matrix[7 - blackRow][blackColumn] = 'b';
            }
            if (whiteRow == 0) {
                letter = getLetter(whiteColumn);
                System.out.println("Game over! White pawn is promoted to a queen at " + letter + 8 + ".");
            } else if (blackRow == 0) {
                letter = getLetter(blackColumn);
                System.out.println("Game over! Black pawn is promoted to a queen at " + letter + 1 + ".");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static char getLetter(int column) {
        char letter;
        if (column == 0) {
            letter = 'a';
        } else if (column == 1) {
            letter = 'b';
        } else if (column == 2) {
            letter = 'c';
        } else if (column == 3) {
            letter = 'd';
        } else if (column == 4) {
            letter = 'e';
        } else if (column == 5) {
            letter = 'f';
        } else if (column == 6) {
            letter = 'g';
        } else {
            letter = 'h';
        }
        return letter;
    }

}

