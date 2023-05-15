package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixShuffling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];

        String[][] matrix = new String[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String command = scanner.nextLine();

        String regex = "swap \\d+ \\d+ \\d+ \\d+";
        Pattern pattern = Pattern.compile(regex);

        while (!command.equals("END")) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.matches()) {
                int[] coordinatesArray = Arrays.stream(command.substring(5).split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int row1 = coordinatesArray[0];
                if (row1 >= 0 && row1 <= rows - 1) {
                    int col1 = coordinatesArray[1];
                    if (col1 >= 0 && col1 <= columns - 1) {
                        String firstElement = matrix[row1][col1];
                        int row2 = coordinatesArray[2];
                        if (row2 >= 0 && row2 <= rows - 1) {
                            int col2 = coordinatesArray[3];
                            if (col2 >= 0 && col2 <= columns - 1) {
                                String secondElement = matrix[row2][col2];
                                matrix[row1][col1] = secondElement;
                                matrix[row2][col2] = firstElement;
                                print(matrix);
                            } else {
                                System.out.println("Invalid input!");
                            }
                        } else {
                            System.out.println("Invalid input!");
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }

        scanner.close();

    }

    private static void print(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
