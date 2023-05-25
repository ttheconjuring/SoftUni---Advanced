package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> numbersList = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            Collections.reverse(numbersList);
            int n = Integer.parseInt(bufferedReader.readLine());
            Predicate<Integer> isDivisible = number -> number % n == 0;
            numbersList.removeIf(isDivisible);
            numbersList.forEach(e -> System.out.print(e + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
