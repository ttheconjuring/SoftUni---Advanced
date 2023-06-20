package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Function<List<Integer>, Integer> printMin = list -> {
                Collections.sort(list);
                return list.get(0);
            };
            System.out.println(printMin.apply(Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList())));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
