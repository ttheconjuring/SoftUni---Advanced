package RegularExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MouseInTheKitchen {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] dimensions = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int n = dimensions[0];
            int m = dimensions[1];
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int mouseRow = -1;
            int mouseColumn = -1;
            int cheeseCounter = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 'M') {
                        mouseRow = i;
                        mouseColumn = j;
                    } else if (matrix[i][j] == 'C') {
                        cheeseCounter++;
                    }
                }
            }
            boolean steppedOutsideTheCupboardArea = false;
            boolean trapped = false;
            int eatenCheese = 0;
            String command = bufferedReader.readLine();
            while (!command.equals("danger")) {
                if (!steppedOutsideTheCupboardArea && (eatenCheese != cheeseCounter) && !trapped) {
                    switch (command) {
                        case "up":
                            if (mouseRow - 1 >= 0) {
                                if (matrix[mouseRow - 1][mouseColumn] == 'C') {
                                    eatenCheese++;
                                    matrix[mouseRow - 1][mouseColumn] = '*';
                                    matrix[mouseRow--][mouseColumn] = '*';
                                } else if (matrix[mouseRow - 1][mouseColumn] == 'T') {
                                    trapped = true;
                                    matrix[mouseRow--][mouseColumn] = '*';
                                } else if (matrix[mouseRow - 1][mouseColumn] == '*') {
                                    matrix[mouseRow - 1][mouseColumn] = 'M';
                                    matrix[mouseRow--][mouseColumn] = '*';
                                }
                            } else {
                                steppedOutsideTheCupboardArea = true;
                            }
                            break;
                        case "down":
                            if (mouseRow + 1 < n) {
                                if (matrix[mouseRow + 1][mouseColumn] == 'C') {
                                    eatenCheese++;
                                    matrix[mouseRow + 1][mouseColumn] = '*';
                                    matrix[mouseRow++][mouseColumn] = '*';
                                } else if (matrix[mouseRow + 1][mouseColumn] == 'T') {
                                    trapped = true;
                                    matrix[mouseRow++][mouseColumn] = '*';
                                } else if (matrix[mouseRow + 1][mouseColumn] == '*') {
                                    matrix[mouseRow + 1][mouseColumn] = 'M';
                                    matrix[mouseRow++][mouseColumn] = '*';
                                }
                            } else {
                                steppedOutsideTheCupboardArea = true;
                            }
                            break;
                        case "left":
                            if (mouseColumn - 1 >= 0) {
                                if (matrix[mouseRow][mouseColumn - 1] == 'C') {
                                    eatenCheese++;
                                    matrix[mouseRow][mouseColumn - 1] = '*';
                                    matrix[mouseRow][mouseColumn--] = '*';
                                } else if (matrix[mouseRow][mouseColumn - 1] == 'T') {
                                    trapped = true;
                                    matrix[mouseRow][mouseColumn--] = '*';
                                } else if (matrix[mouseRow][mouseColumn - 1] == '*') {
                                    matrix[mouseRow][mouseColumn - 1] = 'M';
                                    matrix[mouseRow][mouseColumn--] = '*';
                                }
                            } else {
                                steppedOutsideTheCupboardArea = true;
                            }
                            break;
                        case "right":
                            if (mouseColumn + 1 < m) {
                                if (matrix[mouseRow][mouseColumn + 1] == 'C') {
                                    eatenCheese++;
                                    matrix[mouseRow][mouseColumn + 1] = '*';
                                    matrix[mouseRow][mouseColumn++] = '*';
                                } else if (matrix[mouseRow][mouseColumn + 1] == 'T') {
                                    trapped = true;
                                    matrix[mouseRow][mouseColumn++] = '*';
                                } else if (matrix[mouseRow][mouseColumn + 1] == '*') {
                                    matrix[mouseRow][mouseColumn + 1] = 'M';
                                    matrix[mouseRow][mouseColumn++] = '*';
                                }
                            } else {
                                steppedOutsideTheCupboardArea = true;
                            }
                            break;
                    }
                }
                command = bufferedReader.readLine();
            }
            matrix[mouseRow][mouseColumn] = 'M';
            if (steppedOutsideTheCupboardArea) {
                System.out.println("No more cheese for tonight!");
            } else if (eatenCheese == cheeseCounter) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
            } else if (trapped) {
                System.out.println("Mouse is trapped!");
            } else {
                System.out.println("Mouse will come back later!");
            }
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
