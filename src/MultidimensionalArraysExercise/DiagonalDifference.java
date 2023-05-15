package MultidimensionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int primaryDiagonal = 0;
        int i = 0;
        int j = 0;
        while ((i < n) && (j < n)) {
            primaryDiagonal += matrix[i++][j++];
        }

        int secondaryDiagonal = 0;
        j = 0;
        i = n - 1;
        while ((i >= 0) && (j <= n - 1)) {
            secondaryDiagonal += matrix[i--][j++];
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));

        scanner.close();
    }

}
