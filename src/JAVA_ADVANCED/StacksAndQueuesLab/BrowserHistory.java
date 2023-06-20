package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> browserHistoryStack = new ArrayDeque<>();

        String input = sc.nextLine();
        String currentURL = "";

        while (!input.equals("Home")) {
            if(input.equals("back")) {
                if(!browserHistoryStack.isEmpty()) {
                    currentURL = browserHistoryStack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = sc.nextLine();
                    continue;
                }
            } else {
                if(!currentURL.isEmpty()) {
                    browserHistoryStack.push(currentURL);
                }
                currentURL = input;
            }
            System.out.println(currentURL);
            input = sc.nextLine();
        }

        sc.close();
    }

}
