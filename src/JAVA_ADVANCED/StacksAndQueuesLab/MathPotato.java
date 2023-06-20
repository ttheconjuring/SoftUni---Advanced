package StacksAndQueuesLab;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String children = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());

        String[] child = children.split("\\s+");

        PriorityQueue<String> players = new PriorityQueue<>();
        for (int i = 0; i < child.length; i++) {
            players.offer(child[i]);
        }

        int i = 1;
        int cycle = 1;
        while (players.size() > 1) {
            if (i != n) {
                players.offer(players.poll());
                i++;
            } else {
                if (isPrime(cycle)) {
                    System.out.println("Prime " + players.peek());
                } else {
                    System.out.println("Removed " + players.poll());
                }
                i = 1;
                cycle++;
            }
        }

        System.out.println("Last is " + players.poll());

        sc.close();
    }

    public static boolean isPrime(int cycle) {
        if (cycle == 1 || cycle == 0) {
            return false;
        }
        boolean flag = true;
        for (int i = 2; i <= cycle / 2; ++i) {
            if (cycle % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}

