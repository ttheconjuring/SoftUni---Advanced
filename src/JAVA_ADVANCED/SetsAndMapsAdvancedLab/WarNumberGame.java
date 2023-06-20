package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class WarNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerDeckSet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayerDeckSet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 0;

        while (rounds != 50) {
            if(!firstPlayerDeckSet.isEmpty()) {
                if(!secondPlayerDeckSet.isEmpty()) {
                    int firstPlayerFirstCard = firstPlayerDeckSet.iterator().next();
                    firstPlayerDeckSet.remove(firstPlayerFirstCard);
                    int secondPlayerFirstCard = secondPlayerDeckSet.iterator().next();
                    secondPlayerDeckSet.remove(secondPlayerFirstCard);
                    if(firstPlayerFirstCard > secondPlayerFirstCard) {
                        firstPlayerDeckSet.add(firstPlayerFirstCard);
                        firstPlayerDeckSet.add(secondPlayerFirstCard);
                    } else if(firstPlayerFirstCard < secondPlayerFirstCard) {
                        secondPlayerDeckSet.add(firstPlayerFirstCard);
                        secondPlayerDeckSet.add(secondPlayerFirstCard);
                    } else {
                        firstPlayerDeckSet.add(firstPlayerFirstCard);
                        secondPlayerDeckSet.add(secondPlayerFirstCard);
                    }
                } else {
                    System.out.println("First player win!");
                    return;
                }
            } else {
                System.out.println("Second player win!");
                return;
            }
            rounds++;
        }

        if(firstPlayerDeckSet.size() > secondPlayerDeckSet.size()) {
            System.out.println("First player win!");
        } else if(firstPlayerDeckSet.size() < secondPlayerDeckSet.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

        scanner.close();
    }

}
