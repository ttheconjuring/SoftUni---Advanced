package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String input = sc.nextLine();

        while (!input.equals("print")) {
            if(input.equals("cancel")) {
                if(!printerQueue.isEmpty()) {
                    System.out.println("Canceled " + printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }
            input = sc.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }

        sc.close();
    }

}
