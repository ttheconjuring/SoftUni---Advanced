package JAVA_OOP.WotkingWithAbstractionExercise.CardSuit;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("Card Suits:");
        Arrays.stream(CardSuits.values()).forEach(CardSuits::print);

    }

}
