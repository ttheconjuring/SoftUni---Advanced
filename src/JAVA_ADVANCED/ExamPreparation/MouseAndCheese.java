package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MouseAndCheese {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int mouseRow = -1;
            int mouseColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'M') {
                        mouseRow = i;
                        mouseColumn = j;
                    }
                }
            }
            int cheese = 0;
            boolean wentOut = false;
            String command = bufferedReader.readLine();
            while (!command.equals("end")) {
                switch (command) {
                    case "up":
                        if (mouseRow - 1 >= 0) {
                            if (matrix[mouseRow - 1][mouseColumn] == 'c') {
                                cheese++;
                                matrix[mouseRow - 1][mouseColumn] = 'M';
                                matrix[mouseRow--][mouseColumn] = '-';
                            } else if (matrix[mouseRow - 1][mouseColumn] == 'B') {
                                matrix[mouseRow - 1][mouseColumn] = '-';
                                matrix[mouseRow--][mouseColumn] = '-';
                                if (mouseRow - 1 >= 0) {
                                    if (matrix[mouseRow - 1][mouseColumn] == 'c') {
                                        cheese++;
                                    }
                                    matrix[mouseRow - 1][mouseColumn] = 'M';
                                    matrix[mouseRow--][mouseColumn] = '-';
                                } else {
                                    wentOut = true;
                                }
                            } else {
                                matrix[mouseRow - 1][mouseColumn] = 'M';
                                matrix[mouseRow--][mouseColumn] = '-';
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                    case "down":
                        if (mouseRow + 1 < n) {
                            if (matrix[mouseRow + 1][mouseColumn] == 'c') {
                                cheese++;
                                matrix[mouseRow + 1][mouseColumn] = 'M';
                                matrix[mouseRow++][mouseColumn] = '-';
                            } else if (matrix[mouseRow + 1][mouseColumn] == 'B') {
                                matrix[mouseRow + 1][mouseColumn] = '-';
                                matrix[mouseRow++][mouseColumn] = '-';
                                if (mouseRow + 1 < n) {
                                    if (matrix[mouseRow + 1][mouseColumn] == 'c') {
                                        cheese++;
                                    }
                                    matrix[mouseRow + 1][mouseColumn] = 'M';
                                    matrix[mouseRow++][mouseColumn] = '-';
                                } else {
                                    wentOut = true;
                                }
                            } else {
                                matrix[mouseRow + 1][mouseColumn] = 'M';
                                matrix[mouseRow++][mouseColumn] = '-';
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                    case "left":
                        if (mouseColumn - 1 >= 0) {
                            if (matrix[mouseRow][mouseColumn - 1] == 'c') {
                                cheese++;
                                matrix[mouseRow][mouseColumn - 1] = 'M';
                                matrix[mouseRow][mouseColumn--] = '-';
                            } else if (matrix[mouseRow][mouseColumn - 1] == 'B') {
                                matrix[mouseRow][mouseColumn - 1] = '-';
                                matrix[mouseRow][mouseColumn--] = '-';
                                if (mouseColumn - 1 >= 0) {
                                    if (matrix[mouseRow][mouseColumn - 1] == 'c') {
                                        cheese++;
                                    }
                                    matrix[mouseRow][mouseColumn - 1] = 'M';
                                    matrix[mouseRow][mouseColumn--] = '-';
                                } else {
                                    wentOut = true;
                                }
                            } else {
                                matrix[mouseRow][mouseColumn - 1] = 'M';
                                matrix[mouseRow][mouseColumn--] = '-';
                            }
                        } else {
                            wentOut = true;
                        }
                        break;
                    case "right":
                        if (mouseColumn + 1 < n) {
                            if (matrix[mouseRow][mouseColumn + 1] == 'c') {
                                cheese++;
                                matrix[mouseRow][mouseColumn + 1] = 'M';
                                matrix[mouseRow][mouseColumn++] = '-';
                            } else if (matrix[mouseRow][mouseColumn + 1] == 'B') {
                                matrix[mouseRow][mouseColumn + 1] = '-';
                                matrix[mouseRow][mouseColumn++] = '-';
                                if (mouseColumn + 1 < n) {
                                    if (matrix[mouseRow][mouseColumn + 1] == 'c') {
                                        cheese++;
                                    }
                                    matrix[mouseRow][mouseColumn + 1] = 'M';
                                    matrix[mouseRow][mouseColumn++] = '-';
                                } else {
                                    wentOut = true;
                                }
                            } else {
                                matrix[mouseRow][mouseColumn + 1] = 'M';
                                matrix[mouseRow][mouseColumn++] = '-';
                            }
                        } else {
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
                matrix[mouseRow][mouseColumn] = '-';
                System.out.println("Where is the mouse?");
            }
            if (cheese < 5) {
                System.out.println("The mouse couldn't eat the cheeses, she needed " + (5 - cheese) + " cheeses more.");
            } else {
                System.out.println("Great job, the mouse is fed " + cheese + " cheeses!");
            }
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
