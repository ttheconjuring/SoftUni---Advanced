package FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindEvensOrOdds {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] range = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int lowerBound = range[0];
            int upperBound = range[1];
            String criteria = bufferedReader.readLine();
            Predicate<Integer> isEven = i -> i % 2 == 0;
            for (int i = lowerBound; i <= upperBound; i++) {
                if(criteria.equals("even")) {
                    if(isEven.test(i)) {
                        System.out.print(i + " ");
                    }
                } else {
                    if(!isEven.test(i)) {
                        System.out.print(i + " ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
