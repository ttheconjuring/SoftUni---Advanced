package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> binaryRepresentationStack = new ArrayDeque<>();

        int n = Integer.parseInt(sc.nextLine());

        if(n == 0) {
            System.out.println(0);
        } else {
            while (n > 0) {
                binaryRepresentationStack.push(n % 2);
                n /= 2;
            }
        }

        while (!binaryRepresentationStack.isEmpty()) {
            System.out.print(binaryRepresentationStack.pop());
        }

        sc.close();
    }

}
