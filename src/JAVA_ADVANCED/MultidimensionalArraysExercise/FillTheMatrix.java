package MultidimensionalArraysExercise;

import java.util.Scanner;

public class FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);

        int[][] matrix = new int[n][n];

        int filler = 1;
        if (type == 'A') {
            for (int column = 0; column < n; column++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][column] = filler++;
                }
            }
        } else {
            for (int column = 0; column < n; column++) {
                if(column % 2 == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][column] = filler++;
                    }
                } else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][column] = filler++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
