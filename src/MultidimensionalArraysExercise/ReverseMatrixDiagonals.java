package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        if(rows <= 0) {
            return;
        }
        int columns = dimensions[1];
        if(columns <= 0) {
            return;
        }

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        if(columns == 1) {
            for (int i = rows - 1; i >= 0; i--) {
                System.out.println(matrix[i][0]);
            }
            return;
        }

        for (int k = 0; k < columns; k++) {
            int i = rows - 1;
            int j = columns - 1 - k;
            while ((i >= 0) && (j <= columns - 1)) {
                System.out.print(matrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }

        if(rows <= columns) {
            for (int f = 0; f < rows; f++) {
                int i = rows - 2 - f;
                int j = 0;
                while ((i >= 0)) {
                    System.out.print(matrix[i][j] + " ");
                    i--;
                    j++;
                }
                System.out.println();
            }
        } else {
            for (int f = 1; f < rows; f++) {
                int i = rows - 1 - f;
                int j = 0;
                while ((i >= 0) && (j <= columns - 1)) {
                    System.out.print(matrix[i][j] + " ");
                    i--;
                    j++;
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}




