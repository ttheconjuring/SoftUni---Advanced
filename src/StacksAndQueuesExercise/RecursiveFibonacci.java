package StacksAndQueuesExercise;

import java.util.Scanner;
import java.util.*;

public class RecursiveFibonacci {

    private static final Map<Integer, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fibonacci(Integer.parseInt(scanner.nextLine()) + 1));
        scanner.close();
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long fibValue = fibonacci(n - 1) + fibonacci(n - 2);
        memo.put(n, fibValue);
        return fibValue;
    }

}
