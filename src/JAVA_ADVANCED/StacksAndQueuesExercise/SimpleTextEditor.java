package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> oldTextStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.startsWith("1")) {
                oldTextStack.push(currentText.toString());
                currentText.append(input.split("\\s+")[1]);
            } else if (input.startsWith("2")) {
                oldTextStack.push(currentText.toString());
                int count = Integer.parseInt(input.split("\\s+")[1]);
                int j = 0;
                while (j != count) {
                    currentText.deleteCharAt(currentText.length() - 1);
                    j++;
                }
            } else if (input.startsWith("3")) {
                int index = Integer.parseInt(input.split("\\s+")[1]);
                System.out.println(currentText.charAt(index - 1));
            } else {
                currentText.replace(0, currentText.length(), oldTextStack.pop());
            }
        }

        scanner.close();
    }

}
