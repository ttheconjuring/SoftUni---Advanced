package JAVA_OOP.InterfacesAndAbstractionExercise.BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            List<Birthable> birthableList = new ArrayList<>();
            while (!input.equals("End")) {
                String[] inputArray = input.split(" ");
                switch (inputArray[0]) {
                    case "Citizen":
                        birthableList.add(new Citizen(inputArray[1], Integer.parseInt(inputArray[2]), inputArray[3], inputArray[4]));
                        break;
                    case "Pet":
                        birthableList.add(new Pet(inputArray[1], inputArray[2]));
                        break;
                }
                input = bufferedReader.readLine();
            }
            String year = bufferedReader.readLine();
            birthableList.stream().filter(object -> object.getBirthDate().endsWith(year)).forEach(object -> System.out.println(object.getBirthDate()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
