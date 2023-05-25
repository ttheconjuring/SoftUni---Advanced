package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

public class ListOfPredicates {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int range = Integer.parseInt(bufferedReader.readLine());
            int[] denominators = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = denominators.length;
            Set<Predicate<Integer>> predicatesSet = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int specificDenominator = denominators[i];
                Predicate<Integer> specificPredicate = number -> number % specificDenominator == 0;
                predicatesSet.add(specificPredicate);
            }
            boolean isValid = true;
            for (int i = 1; i <= range; i++) {
                for (Predicate<Integer> integerPredicate : predicatesSet) {
                    if(!integerPredicate.test(i)) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) {
                    System.out.print(i + " ");
                } else {
                    isValid = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
