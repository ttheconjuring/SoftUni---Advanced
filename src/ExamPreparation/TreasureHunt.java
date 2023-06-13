package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureHunt {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] dimensions = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = dimensions[0];
            int m = dimensions[1];
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().replace(" ", "").toCharArray();
            }
            int row = -1;
            int column = -1;
            int treasureRow = -1;
            int treasureColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 'Y') {
                        row = i;
                        column = j;
                    } else if (matrix[i][j] == 'X') {
                        treasureRow = i;
                        treasureColumn = j;
                    }
                }
            }
            String command = bufferedReader.readLine();
            List<String> directionsList = new ArrayList<>();
            while (!command.equals("Finish")) {
                switch (command) {
                    case "up":
                        if (row - 1 >= 0) {
                            if (matrix[row - 1][column] != 'T') {
                                matrix[row - 1][column] = 'Y';
                                matrix[row][column] = '-';
                                row--;
                                directionsList.add(command);
                            }
                        }
                        break;
                    case "down":
                        if (row + 1 < n) {
                            if (matrix[row + 1][column] != 'T') {
                                matrix[row + 1][column] = 'Y';
                                matrix[row][column] = '-';
                                row++;
                                directionsList.add(command);
                            }
                        }
                        break;
                    case "right":
                        if (column + 1 < m) {
                            if (matrix[row][column + 1] != 'T') {
                                matrix[row][column + 1] = 'Y';
                                matrix[row][column] = '-';
                                column++;
                                directionsList.add(command);
                            }
                        }
                        break;
                    case "left":
                        if (column - 1 >= 0) {
                            if (matrix[row][column - 1] != 'T') {
                                matrix[row][column - 1] = 'Y';
                                matrix[row][column] = '-';
                                column--;
                                directionsList.add(command);
                            }
                        }
                        break;
                }
                command = bufferedReader.readLine();
            }
            if (row == treasureRow) {
                if (column == treasureColumn) {
                    System.out.println("I've found the treasure!");
                    System.out.println("The right path is " + String.join(", ", directionsList));
                } else {
                    System.out.println("The map is fake!");
                }
            } else {
                System.out.println("The map is fake!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
