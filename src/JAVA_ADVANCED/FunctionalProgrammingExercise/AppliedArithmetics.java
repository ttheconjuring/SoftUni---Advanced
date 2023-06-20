package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> listOfNumbers = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            Function<Integer, Integer> addOne = element -> element + 1;
            Function<Integer, Integer> multiplyByTwo = element -> element * 2;
            Function<Integer, Integer> subtractOne = element -> element - 1;
            Consumer<List<Integer>> printAll = list -> list.forEach(e -> System.out.print(e + " "));
            String command = bufferedReader.readLine();
            while (!command.equals("end")) {
                switch (command) {
                    case "add":
                        listOfNumbers.replaceAll(addOne::apply);
                        break;
                    case "multiply":
                        listOfNumbers.replaceAll(multiplyByTwo::apply);
                        break;
                    case "subtract":
                        listOfNumbers.replaceAll(subtractOne::apply);
                        break;
                    case "print":
                        printAll.accept(listOfNumbers);
                        System.out.println();
                        break;
                }
                command = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
