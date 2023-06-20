package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nameEmailMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        int inputCounter = 1;

        String name = "";
        String email;

        while (!input.equals("stop")) {
            if(inputCounter == 1) {
                name = input;
                inputCounter++;
            } else {
                email = input;
                nameEmailMap.put(name, email);
                inputCounter = 1;
            }
            input = scanner.nextLine();
        }

        nameEmailMap.entrySet().removeIf(entry -> entry.getValue().endsWith("us"));
        nameEmailMap.entrySet().removeIf(entry -> entry.getValue().endsWith("uk"));
        nameEmailMap.entrySet().removeIf(entry -> entry.getValue().endsWith("com"));

        for (Map.Entry<String, String> stringStringEntry : nameEmailMap.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " -> " + stringStringEntry.getValue());
        }




        scanner.close();
    }

}
