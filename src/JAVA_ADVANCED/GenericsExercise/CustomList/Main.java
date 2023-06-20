package GenericsExercise.CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            CustomList<String> stringCustomList = new CustomList<>();
            String command = bufferedReader.readLine();
            while (!command.equals("END")) {
                String[] commandArray = command.split(" ");
                switch (commandArray[0]) {
                    case "Add":
                        stringCustomList.add(commandArray[1]);
                        break;
                    case "Remove":
                        stringCustomList.remove(Integer.parseInt(commandArray[1]));
                        break;
                    case "Contains":
                        System.out.println(stringCustomList.contains(commandArray[1]));
                        break;
                    case "Swap":
                        stringCustomList.swap(Integer.parseInt(commandArray[1]), Integer.parseInt(commandArray[2]));
                        break;
                    case "Greater":
                        System.out.println(stringCustomList.countGreaterThan(commandArray[1]));
                        break;
                    case "Max":
                        System.out.println(stringCustomList.getMax());
                        break;
                    case "Min":
                        System.out.println(stringCustomList.getMin());
                        break;
                    case "Print":
                        stringCustomList.forEach(System.out::println);
                        break;
                }
                command = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
