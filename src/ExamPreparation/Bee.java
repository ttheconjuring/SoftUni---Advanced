package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int beeRow = -1;
            int beeColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'B') {
                        beeRow = i;
                        beeColumn = j;
                    }
                }
            }
            int pollinatedFlowers = 0;
            boolean wentOut = false;
            String command = bufferedReader.readLine();
            while (!command.equals("End")) {
                switch (command) {
                    case "up":
                        if (beeRow - 1 >= 0) {
                            if (matrix[beeRow - 1][beeColumn] == 'O') {
                                matrix[beeRow][beeColumn] = '.';
                                matrix[beeRow - 1][beeColumn] = '.';
                                beeRow--;
                                if (beeRow - 1 >= 0) {
                                    if (matrix[beeRow - 1][beeColumn] == 'f') {
                                        pollinatedFlowers++;
                                    }
                                    matrix[beeRow - 1][beeColumn] = 'B';
                                    beeRow--;
                                    break;
                                } else {
                                    wentOut = true;
                                    break;
                                }
                            } else if (matrix[beeRow - 1][beeColumn] == 'f') {
                                pollinatedFlowers++;
                            }
                            matrix[beeRow - 1][beeColumn] = 'B';
                            matrix[beeRow][beeColumn] = '.';
                            beeRow--;

                        } else {
                            matrix[beeRow][beeColumn] = '.';
                            wentOut = true;
                        }
                        break;
                    case "down":
                        if (beeRow + 1 < n) {
                            if (matrix[beeRow + 1][beeColumn] == 'O') {
                                matrix[beeRow][beeColumn] = '.';
                                matrix[beeRow + 1][beeColumn] = '.';
                                beeRow++;
                                if (beeRow + 1 < n) {
                                    if (matrix[beeRow + 1][beeColumn] == 'f') {
                                        pollinatedFlowers++;
                                    }
                                    matrix[beeRow + 1][beeColumn] = 'B';
                                    beeRow++;
                                    break;
                                } else {
                                    wentOut = true;
                                    break;
                                }
                            } else if (matrix[beeRow + 1][beeColumn] == 'f') {
                                pollinatedFlowers++;
                            }
                            matrix[beeRow + 1][beeColumn] = 'B';
                            matrix[beeRow][beeColumn] = '.';
                            beeRow++;
                        } else {
                            matrix[beeRow][beeColumn] = '.';
                            wentOut = true;
                        }
                        break;
                    case "left":
                        if (beeColumn - 1 >= 0) {
                            if (matrix[beeRow][beeColumn - 1] == 'O') {
                                matrix[beeRow][beeColumn] = '.';
                                matrix[beeRow][beeColumn - 1] = '.';
                                beeColumn--;
                                if (beeColumn - 1 >= 0) {
                                    if (matrix[beeRow][beeColumn - 1] == 'f') {
                                        pollinatedFlowers++;
                                    }
                                    matrix[beeRow][beeColumn - 1] = 'B';
                                    beeColumn--;
                                    break;
                                } else {
                                    wentOut = true;
                                    break;
                                }
                            } else if (matrix[beeRow][beeColumn - 1] == 'f') {
                                pollinatedFlowers++;
                            }
                            matrix[beeRow][beeColumn - 1] = 'B';
                            matrix[beeRow][beeColumn] = '.';
                            beeColumn--;
                        } else {
                            matrix[beeRow][beeColumn] = '.';
                            wentOut = true;
                        }
                        break;
                    case "right":
                        if (beeColumn + 1 < n) {
                            if (matrix[beeRow][beeColumn + 1] == 'O') {
                                matrix[beeRow][beeColumn] = '.';
                                matrix[beeRow][beeColumn + 1] = '.';
                                beeColumn++;
                                if (beeColumn + 1 < n) {
                                    if (matrix[beeRow][beeColumn + 1] == 'f') {
                                        pollinatedFlowers++;
                                    }
                                    matrix[beeRow][beeColumn + 1] = 'B';
                                    beeColumn++;
                                    break;
                                } else {
                                    wentOut = true;
                                    break;
                                }
                            } else if (matrix[beeRow][beeColumn + 1] == 'f') {
                                pollinatedFlowers++;
                            }
                            matrix[beeRow][beeColumn + 1] = 'B';
                            matrix[beeRow][beeColumn] = '.';
                            beeColumn++;
                        } else {
                            matrix[beeRow][beeColumn] = '.';
                            wentOut = true;
                        }
                        break;
                }
                if (wentOut) {
                    break;
                }
                command = bufferedReader.readLine();
            }
            if (wentOut) {
                System.out.println("The bee got lost!");
            }
            if (pollinatedFlowers >= 5) {
                System.out.println("Great job, the bee manage to pollinate " + pollinatedFlowers + " flowers!");
            } else {
                System.out.println("The bee couldn't pollinate the flowers, she needed " + (5 - pollinatedFlowers) + " flowers more");
            }
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
