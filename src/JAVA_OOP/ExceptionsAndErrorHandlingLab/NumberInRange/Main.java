package JAVA_OOP.ExceptionsAndErrorHandlingLab.NumberInRange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] range = bufferedReader.readLine().split(" ");
            int first = Integer.parseInt(range[0]);
            int last = Integer.parseInt(range[1]);
            System.out.println("Range: [" + first + "..." + last + "]");
            while (true) {
                String input = bufferedReader.readLine();
                try {
                    int number = Integer.parseInt(input);
                    if (number < first || number > last) {
                        System.out.println("Invalid number: " + number);
                    } else {
                        System.out.println("Valid number: " + number);
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number: " + input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
