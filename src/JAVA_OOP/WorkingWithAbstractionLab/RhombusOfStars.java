package JAVA_OOP.WorkingWithAbstractionLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 1; i <= n; i++) {
                printRow(n, i);
            }
            for (int i = n - 1; i >= 1; i--) {
                printRow(n, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void printRow(int n, int i) {
        for (int j = 0; j < n - i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

}
