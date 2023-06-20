package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String children = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());

        String[] child = children.split("\\s+");

        ArrayDeque<String> players = new ArrayDeque<>();
        for (int i = 0; i < child.length; i++) {
            players.offer(child[i]);
        }

        int i = 1;
        while (players.size() > 1) {
            if(i != n) {
                String currentPlayer = players.poll();
                players.offer(currentPlayer);
                i++;
            } else {
                System.out.println("Removed " + players.poll());
                i = 1;
            }
        }

        System.out.println("Last is " + players.poll());

        sc.close();
    }

}
