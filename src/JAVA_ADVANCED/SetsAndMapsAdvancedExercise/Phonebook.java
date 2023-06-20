package SetsAndMapsAdvancedExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> peoplePhoneNumbersMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String[] inputArray = input.split("-");
            String person = inputArray[0];
            String personPhoneNumber = inputArray[1];
            peoplePhoneNumbersMap.put(person, personPhoneNumber);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if(peoplePhoneNumbersMap.containsKey(input)) {
                System.out.println(input + " -> " + peoplePhoneNumbersMap.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = scanner.nextLine();
        }

        scanner.close();
    }

}
