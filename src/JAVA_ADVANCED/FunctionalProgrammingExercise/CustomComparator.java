package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class CustomComparator {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> listOfRandomShuffledNumbers = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> listOfEvenNumbers = listOfRandomShuffledNumbers.stream().filter(number -> number % 2 == 0).sorted().collect(Collectors.toList());
            List<Integer> listOfOddNumbers = listOfRandomShuffledNumbers.stream().filter(number -> number % 2 != 0).sorted().collect(Collectors.toList());
            BiConsumer<List<Integer>, List<Integer>> printResult = (list1, list2) -> {
                list1.forEach(e -> System.out.print(e + " "));
                list2.forEach(e -> System.out.print(e + " "));
            };
            printResult.accept(listOfEvenNumbers, listOfOddNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
