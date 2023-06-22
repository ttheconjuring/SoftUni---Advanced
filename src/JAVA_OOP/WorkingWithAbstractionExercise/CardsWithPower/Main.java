package JAVA_OOP.WotkingWithAbstractionExercise.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String cardRank = bufferedReader.readLine();
            String cardSuit = bufferedReader.readLine();
            Card card = new Card(SuitPowers.valueOf(cardSuit), RankPowers.valueOf(cardRank));
            card.printCardPower();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
