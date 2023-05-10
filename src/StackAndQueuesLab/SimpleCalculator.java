package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] inputArray = input.split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = inputArray.length - 1; i >= 0; i--) {
            stack.push(inputArray[i]);
        }

        int result = 0;

        while (stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());
            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    stack.push(String.valueOf(result));
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    stack.push(String.valueOf(result));
                    break;
            }
        }

        System.out.println(stack.pop());

        sc.close();
    }

}
