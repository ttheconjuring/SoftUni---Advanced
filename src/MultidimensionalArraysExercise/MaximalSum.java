package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] biggest3x3Matrix = new int[3][3];

        int[][] current3x3Matrix = new int[3][3];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        current3x3Matrix[k][l] = matrix[i + k][j + l];
                    }
                }
                if (getSumOf(current3x3Matrix) > getSumOf(biggest3x3Matrix)) {
                    copy(biggest3x3Matrix, current3x3Matrix);
                }
            }
        }

        System.out.println("Sum = " + getSumOf(biggest3x3Matrix));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(biggest3x3Matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    private static int getSumOf(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void copy(int[][] copy, int[][] original) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
    }

}
