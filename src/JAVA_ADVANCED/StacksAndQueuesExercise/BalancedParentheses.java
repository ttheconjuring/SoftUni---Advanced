package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    private static boolean isBalanced(String input) {
        ArrayDeque<Character> openingParenthesesStack = new ArrayDeque<>();
        int n = input.length();
        if (n % 2 != 0) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '}') {
                if (!openingParenthesesStack.isEmpty()) {
                    if (openingParenthesesStack.pop() != '{') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (input.charAt(i) == ')') {
                if (!openingParenthesesStack.isEmpty()) {
                    if (openingParenthesesStack.pop() != '(') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (input.charAt(i) == ']') {
                if (!openingParenthesesStack.isEmpty()) {
                    if (openingParenthesesStack.pop() != '[') {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                openingParenthesesStack.push(input.charAt(i));
            }
        }
        return openingParenthesesStack.isEmpty();
    }

}
