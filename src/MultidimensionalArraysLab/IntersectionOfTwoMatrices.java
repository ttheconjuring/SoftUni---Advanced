package MultidimensionalArraysLab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] a = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] matrixElementsArray = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            a[i] = matrixElementsArray;
        }

        char[][] b = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] matrixElementsArray = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            b[i] = matrixElementsArray;
        }

        char[][] c = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] != b[i][j]) {
                    c[i][j] = '*';
                } else {
                    c[i][j] = a[i][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
