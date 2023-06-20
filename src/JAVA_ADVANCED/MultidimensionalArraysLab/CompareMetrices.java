package MultidimensionalArraysLab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CompareMetrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrix1Size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows1 = matrix1Size[0];
        int columns1 = matrix1Size[1];

        int[][] matrix1 = new int[rows1][columns1];

        for (int i = 0; i < rows1; i++) {
            int[] matrixElementsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < columns1; j++) {
                matrix1[i][j] = matrixElementsArray[j];
            }
        }

        int[] matrix2Size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows2 = matrix2Size[0];
        int columns2 = matrix2Size[1];

        int[][] matrix2 = new int[rows2][columns2];

        for (int i = 0; i < rows2; i++) {
            int[] matrixElementsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix2[i] = matrixElementsArray;
        }

        boolean matricesAreEquals = compare(matrix1, matrix2);

        if (matricesAreEquals) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        scanner.close();
    }

    private static boolean compare(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length == matrix2.length) {
            if (matrix1[0].length == matrix2[0].length) {
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[0].length; j++) {
                        if (matrix1[i][j] != matrix2[i][j]) {
                            return false;
                        }
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

}
