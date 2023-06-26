package JAVA_OOP.EncapsulationExercise.AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String name = bufferedReader.readLine();
            int age = Integer.parseInt(bufferedReader.readLine());
            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
