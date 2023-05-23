package FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> numbersList = Arrays.stream(bufferedReader.readLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println("Count = " + numbersList.size());
            Function<List<Integer>, Integer> printSum = list -> {
                int sum = 0;
                for (Integer integer : list) {
                    sum += integer;
                }
                return sum;
            };
            System.out.println("Sum = " + printSum.apply(numbersList));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
