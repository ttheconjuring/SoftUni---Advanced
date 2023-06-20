package MultidimensionalArraysLab;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] matrixElementsArray = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = matrixElementsArray;
        }

        int[][] twoDimensionalSumMatrix = new int[2][2];

        int[][] theBiggestMatrix = {
                {0, 0},
                {0, 0}
        };
        int theBiggestSum = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                twoDimensionalSumMatrix[0][0] = matrix[i][j];
                twoDimensionalSumMatrix[0][1] = matrix[i][j + 1];
                twoDimensionalSumMatrix[1][0] = matrix[i + 1][j];
                twoDimensionalSumMatrix[1][1] = matrix[i + 1][j + 1];
                if(theBiggestSum < getSumOf(twoDimensionalSumMatrix)) {
                    replace(theBiggestMatrix, twoDimensionalSumMatrix);
                    theBiggestSum = getSumOf(twoDimensionalSumMatrix);
                }
            }
        }

        print(theBiggestMatrix);
        System.out.println(theBiggestSum);

        scanner.close();
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getSumOf(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static void replace(int[][] matrix1, int[][] matrix2) {
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix1[i][j] = matrix2[i][j];
            }
        }
    }

}
