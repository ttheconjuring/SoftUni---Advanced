package FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Consumer<String> print = System.out::println;
            Arrays.stream(bufferedReader.readLine().split(" ")).forEach(print);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
