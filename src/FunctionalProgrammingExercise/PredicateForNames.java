package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Predicate<String> isValid = name -> name.length() <= n;
            Arrays.stream(bufferedReader.readLine().split(" ")).filter(isValid).collect(Collectors.toList()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
