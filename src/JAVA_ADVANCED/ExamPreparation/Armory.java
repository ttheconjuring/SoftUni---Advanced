package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armory {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int armyOfficerRow = -1;
            int armyOfficerColumn = -1;
            int mirrorOneRow = -1;
            int mirrorOneColumn = -1;
            int mirrorTwoRow = -1;
            int mirrorTwoColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'A') {
                        armyOfficerRow = i;
                        armyOfficerColumn = j;
                    } else if (matrix[i][j] == 'M') {
                        if (mirrorOneRow == -1 && mirrorOneColumn == -1) {
                            mirrorOneRow = i;
                            mirrorOneColumn = j;
                        } else if (mirrorTwoRow == -1 && mirrorTwoColumn == -1) {
                            mirrorTwoRow = i;
                            mirrorTwoColumn = j;
                        }
                    }
                }
            }
            int swordsPrice = 0;
            boolean wentOut = false;
            boolean gotTheMoney = false;
            do {
                String command = bufferedReader.readLine();
                switch (command) {
                    case "up":
                        if (armyOfficerRow - 1 >= 0) {
                            if (Character.isDigit(matrix[armyOfficerRow - 1][armyOfficerColumn])) {
                                swordsPrice += Integer.parseInt(String.valueOf(matrix[armyOfficerRow - 1][armyOfficerColumn]));
                                matrix[armyOfficerRow - 1][armyOfficerColumn] = 'A';
                                matrix[armyOfficerRow--][armyOfficerColumn] = '-';
                                if (swordsPrice >= 65) {
                                    gotTheMoney = true;
                                }
                            } else {
                                if (matrix[armyOfficerRow - 1][armyOfficerColumn] == 'M') {
                                    matrix[armyOfficerRow - 1][armyOfficerColumn] = '-';
                                    matrix[armyOfficerRow--][armyOfficerColumn] = '-';
                                    if ((armyOfficerRow == mirrorOneRow) && (armyOfficerColumn == mirrorOneColumn)) {
                                        armyOfficerRow = mirrorTwoRow;
                                        armyOfficerColumn = mirrorTwoColumn;
                                    } else {
                                        armyOfficerRow = mirrorOneRow;
                                        armyOfficerColumn = mirrorOneColumn;
                                    }
                                    matrix[armyOfficerRow][armyOfficerColumn] = 'A';
                                } else {
                                    matrix[armyOfficerRow - 1][armyOfficerColumn] = 'A';
                                    matrix[armyOfficerRow--][armyOfficerColumn] = '-';
                                }
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                    case "down":
                        if (armyOfficerRow + 1 < n) {
                            if (Character.isDigit(matrix[armyOfficerRow + 1][armyOfficerColumn])) {
                                swordsPrice += Integer.parseInt(String.valueOf(matrix[armyOfficerRow + 1][armyOfficerColumn]));
                                matrix[armyOfficerRow + 1][armyOfficerColumn] = 'A';
                                matrix[armyOfficerRow++][armyOfficerColumn] = '-';
                                if (swordsPrice >= 65) {
                                    gotTheMoney = true;
                                }
                            } else {
                                if (matrix[armyOfficerRow + 1][armyOfficerColumn] == 'M') {
                                    matrix[armyOfficerRow + 1][armyOfficerColumn] = '-';
                                    matrix[armyOfficerRow++][armyOfficerColumn] = '-';
                                    if ((armyOfficerRow == mirrorOneRow) && (armyOfficerColumn == mirrorOneColumn)) {
                                        armyOfficerRow = mirrorTwoRow;
                                        armyOfficerColumn = mirrorTwoColumn;
                                    } else {
                                        armyOfficerRow = mirrorOneRow;
                                        armyOfficerColumn = mirrorOneColumn;
                                    }
                                    matrix[armyOfficerRow][armyOfficerColumn] = 'A';
                                } else {
                                    matrix[armyOfficerRow + 1][armyOfficerColumn] = 'A';
                                    matrix[armyOfficerRow++][armyOfficerColumn] = '-';
                                }
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                    case "left":
                        if (armyOfficerColumn - 1 >= 0) {
                            if (Character.isDigit(matrix[armyOfficerRow][armyOfficerColumn - 1])) {
                                swordsPrice += Integer.parseInt(String.valueOf(matrix[armyOfficerRow][armyOfficerColumn - 1]));
                                matrix[armyOfficerRow][armyOfficerColumn - 1] = 'A';
                                matrix[armyOfficerRow][armyOfficerColumn--] = '-';
                                if (swordsPrice >= 65) {
                                    gotTheMoney = true;
                                }
                            } else {
                                if (matrix[armyOfficerRow][armyOfficerColumn - 1] == 'M') {
                                    matrix[armyOfficerRow][armyOfficerColumn - 1] = '-';
                                    matrix[armyOfficerRow][armyOfficerColumn--] = '-';
                                    if ((armyOfficerRow == mirrorOneRow) && (armyOfficerColumn == mirrorOneColumn)) {
                                        armyOfficerRow = mirrorTwoRow;
                                        armyOfficerColumn = mirrorTwoColumn;
                                    } else {
                                        armyOfficerRow = mirrorOneRow;
                                        armyOfficerColumn = mirrorOneColumn;
                                    }
                                    matrix[armyOfficerRow][armyOfficerColumn] = 'A';
                                } else {
                                    matrix[armyOfficerRow][armyOfficerColumn - 1] = 'A';
                                    matrix[armyOfficerRow][armyOfficerColumn--] = '-';
                                }
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                    case "right":
                        if (armyOfficerColumn + 1 < n) {
                            if (Character.isDigit(matrix[armyOfficerRow][armyOfficerColumn + 1])) {
                                swordsPrice += Integer.parseInt(String.valueOf(matrix[armyOfficerRow][armyOfficerColumn + 1]));
                                matrix[armyOfficerRow][armyOfficerColumn + 1] = 'A';
                                matrix[armyOfficerRow][armyOfficerColumn++] = '-';
                                if (swordsPrice >= 65) {
                                    gotTheMoney = true;
                                }
                            } else {
                                if (matrix[armyOfficerRow][armyOfficerColumn + 1] == 'M') {
                                    matrix[armyOfficerRow][armyOfficerColumn + 1] = '-';
                                    matrix[armyOfficerRow][armyOfficerColumn++] = '-';
                                    if ((armyOfficerRow == mirrorOneRow) && (armyOfficerColumn == mirrorOneColumn)) {
                                        armyOfficerRow = mirrorTwoRow;
                                        armyOfficerColumn = mirrorTwoColumn;
                                    } else {
                                        armyOfficerRow = mirrorOneRow;
                                        armyOfficerColumn = mirrorOneColumn;
                                    }
                                    matrix[armyOfficerRow][armyOfficerColumn] = 'A';
                                } else {
                                    matrix[armyOfficerRow][armyOfficerColumn + 1] = 'A';
                                    matrix[armyOfficerRow][armyOfficerColumn++] = '-';
                                }
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                }
            } while (!wentOut && !gotTheMoney);
            if (wentOut) {
                matrix[armyOfficerRow][armyOfficerColumn] = '-';
                System.out.println("I do not need more swords!");
            } else {
                System.out.println("Very nice swords, I will come back for more!");
            }
            System.out.println("The king paid " + swordsPrice + " gold coins.");
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
