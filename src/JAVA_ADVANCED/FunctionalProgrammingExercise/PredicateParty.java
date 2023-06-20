package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PredicateParty {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> listOfNames = Arrays.stream(bufferedReader.readLine().split(" ")).collect(Collectors.toList());
            String command = bufferedReader.readLine();
            while (!command.equals("Party!")) {
                String[] commandArray = command.split(" ");
                switch (commandArray[0]) {
                    case "Remove":
                        switch (commandArray[1]) {
                            case "StartsWith":
                                listOfNames.removeIf(name -> name.startsWith(commandArray[2]));
                                break;
                            case "EndsWith":
                                listOfNames.removeIf(name -> name.endsWith(commandArray[2]));
                                break;
                            case "Length":
                                listOfNames.removeIf(name -> name.length() == Integer.parseInt(commandArray[2]));
                                break;
                        }
                        break;
                    case "Double":
                        switch (commandArray[1]) {
                            case "StartsWith":
                                listOfNames.addAll(listOfNames.stream().filter(name -> name.startsWith(commandArray[2])).collect(Collectors.toList()));
                                break;
                            case "EndsWith":
                                listOfNames.addAll(listOfNames.stream().filter(name -> name.endsWith(commandArray[2])).collect(Collectors.toList()));
                                break;
                            case "Length":
                                listOfNames.addAll(listOfNames.stream().filter(name -> name.length() == Integer.parseInt(commandArray[2])).collect(Collectors.toList()));
                                break;
                        }
                        break;

                }
                command = bufferedReader.readLine();
            }
            if (!listOfNames.isEmpty()) {
                Collections.sort(listOfNames);
                System.out.println(String.join(", ", listOfNames) + " are going to the party!");
            } else {
                System.out.println("Nobody is going to the party!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}