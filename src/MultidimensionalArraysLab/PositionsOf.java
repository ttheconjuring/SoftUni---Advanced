package MultidimensionalArraysLab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixDimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixDimensions[0];
        int columns = matrixDimensions[1];

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] matrixElementsArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = matrixElementsArray;
        }

        int n = Integer.parseInt(scanner.nextLine());

        boolean nFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j] == n) {
                    System.out.println(i + " " + j);
                    nFound = true;
                }
            }
        }

        if(!nFound) {
            System.out.println("not found");
        }

        scanner.close();
    }

}
