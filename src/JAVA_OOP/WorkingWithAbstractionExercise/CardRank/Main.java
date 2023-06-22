package JAVA_OOP.WotkingWithAbstractionExercise.CardRank;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        Arrays.stream(CardRanks.values()).forEach(CardRanks::print);

    }

}
