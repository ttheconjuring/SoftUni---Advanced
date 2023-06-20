package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(numbersStack::push);
        numbersStack.forEach(e -> System.out.print(e + " "));
        sc.close();
    }

}
