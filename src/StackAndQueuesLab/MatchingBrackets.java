package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        ArrayDeque<Integer> indexesStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (currentCharacter == '(') {
                indexesStack.push(i);
            } else if(currentCharacter == ')') {
                System.out.println(input.substring(indexesStack.pop(), i + 1));
            }
        }

        sc.close();
    }

}
