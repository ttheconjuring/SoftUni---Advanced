package JAVA_OOP.InterfacesAndAbstractionLab.BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Identifiable> identifiableList = new ArrayList<>();
            String input = bufferedReader.readLine();
            while (!input.equals("End")) {
                String[] inputArray = input.split(" ");
                if (inputArray.length == 3) {
                    String name = inputArray[0];
                    int age = Integer.parseInt(inputArray[1]);
                    String id = inputArray[2];
                    identifiableList.add(new Citizen(name, age, id));
                } else {
                    String model = inputArray[0];
                    String id = inputArray[1];
                    identifiableList.add(new Robot(id, model));
                }
                input = bufferedReader.readLine();
            }
            String lastDigits = bufferedReader.readLine();
           identifiableList.stream().filter(identifiable -> identifiable.getId().endsWith(lastDigits)).forEach(identifiable -> System.out.println(identifiable.getId()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
