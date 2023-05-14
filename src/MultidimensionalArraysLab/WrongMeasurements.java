package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensions = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimensions][];

        for (int i = 0; i < dimensions; i++) {
            int[] matrixElementsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = matrixElementsArray;
        }

        int[] mistakenValueCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int mistakenValue = matrix[mistakenValueCoordinates[0]][mistakenValueCoordinates[1]];

        int[][] modifiedMatrix = new int[dimensions][matrix[0].length];


        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == mistakenValue) {
                    int up = 0;
                    if (i != 0) {
                        if (matrix[i - 1][j] != mistakenValue) {
                            up = matrix[i - 1][j];
                        }
                    }
                    int down = 0;
                    if (i != dimensions - 1) {
                        if (matrix[i + 1][j] != mistakenValue) {
                            down = matrix[i + 1][j];
                        }
                    }
                    int left = 0;
                    if (j != 0) {
                        if (matrix[i][j - 1] != mistakenValue) {
                            left = matrix[i][j - 1];
                        }
                    }
                    int right = 0;
                    if (j != matrix[i].length - 1) {
                        if (matrix[i][j + 1] != mistakenValue) {
                            right = matrix[i][j + 1];
                        }
                    }
                    modifiedMatrix[i][j] = up + down + left + right;
                } else {
                    modifiedMatrix[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(modifiedMatrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
