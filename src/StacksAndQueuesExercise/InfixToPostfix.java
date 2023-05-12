package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InfixToPostfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> operatorPrecedenceMap = new HashMap<>();
        operatorPrecedenceMap.put("+", 1);
        operatorPrecedenceMap.put("-", 1);
        operatorPrecedenceMap.put("*", 2);
        operatorPrecedenceMap.put("/", 2);

        String[] tokensArray = scanner.nextLine().split(" ");
        int n = tokensArray.length;

        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String token : tokensArray) {
            if (token.matches("[0-9]+") || token.matches("[a-z]+")) {
                outputQueue.offer(token);
            } else if (operatorPrecedenceMap.containsKey(token)) {
                while (!operatorStack.isEmpty() &&
                        operatorPrecedenceMap.containsKey(operatorStack.peek()) &&
                        operatorPrecedenceMap.get(token) <= operatorPrecedenceMap.get(operatorStack.peek())) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().equals("(")) {
                    operatorStack.pop();
                } else {
                    System.out.println("Mismatched parentheses");
                }
            } else {
                System.out.println("Invalid token: " + token);
            }
        }

        while (!operatorStack.isEmpty()) {
            if(operatorStack.peek().equals("(")) {
                System.out.println("Mismatched parentheses");
            }
            outputQueue.offer(operatorStack.pop());
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }

        scanner.close();
    }

}
