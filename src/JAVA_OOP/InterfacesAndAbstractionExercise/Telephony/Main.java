package JAVA_OOP.InterfacesAndAbstractionExercise.Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Smartphone smartphone = new Smartphone(List.of(bufferedReader.readLine().split(" ")), List.of(bufferedReader.readLine().split(" ")));
            System.out.print(smartphone.call());
            System.out.print(smartphone.browse());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
