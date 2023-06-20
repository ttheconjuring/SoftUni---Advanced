package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input = sc.nextLine();
        String currentURL = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!browserHistoryStack.isEmpty()) {
                    forwardStack.push(currentURL);
                    currentURL = browserHistoryStack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = sc.nextLine();
                    continue;
                }
            } else if (input.equals("forward")) {
                if(!forwardStack.isEmpty()) {
                    browserHistoryStack.push(currentURL);
                    currentURL = forwardStack.pop();
                } else {
                    System.out.println("no next URLs");
                    input = sc.nextLine();
                    continue;
                }
            } else {
                if (!currentURL.isEmpty()) {
                    browserHistoryStack.push(currentURL);
                }
                forwardStack.clear();
                currentURL = input;
            }
            System.out.println(currentURL);
            input = sc.nextLine();
        }

        sc.close();
    }

}
