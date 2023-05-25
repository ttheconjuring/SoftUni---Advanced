package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindTheSmallestElement {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Function<int[], Integer> findAndPrintTheSmallestInteger = array -> {
                int index = -1;
                int min = Integer.MAX_VALUE;
                for (int i = array.length - 1; i >= 0; i--) {
                    if(array[i] < min) {
                        index = i;
                        min = array[index];
                    }
                }
                return index;
            };
            System.out.println(findAndPrintTheSmallestInteger.apply(Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
