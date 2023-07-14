package JAVA_OOP.ExceptionsAndErrorHandlingLab.SquareRoot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try {
                int number = Integer.parseInt(bufferedReader.readLine());
                if (number < 0) {
                    throw new IllegalArgumentException();
                } else {
                    System.out.printf("%.2f%n", Math.sqrt(number));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid");
            } finally {
                System.out.println("Goodbye");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
