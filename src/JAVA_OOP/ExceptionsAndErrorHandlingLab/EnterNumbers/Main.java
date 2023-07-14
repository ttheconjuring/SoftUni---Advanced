package JAVA_OOP.ExceptionsAndErrorHandlingLab.EnterNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> numberList = new ArrayList<>();
        while (numberList.size() < 10) {
            try {
                if (numberList.isEmpty()) {
                    numberList.add(String.valueOf(readNumber(1)));
                } else {
                    numberList.add(String.valueOf(readNumber(Integer.parseInt(numberList.get(numberList.size() - 1)))));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Number!");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(String.join(", ", numberList));

    }

    private static int readNumber(int start) {
        int number = Integer.parseInt(scanner.nextLine());
        if (number > start && number < 100) {
            return number;
        }
        throw new ArithmeticException("Your number is not in range " + start + " - " + 100 + "!");
    }

}
