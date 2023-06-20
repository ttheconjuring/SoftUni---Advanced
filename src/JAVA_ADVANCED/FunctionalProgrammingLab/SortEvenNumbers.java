package FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {

    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> numbersList = new java.util.ArrayList<>(Arrays.stream(bufferedReader.readLine().split(", ")).map(Integer::parseInt).filter(number -> number % 2 == 0).collect(Collectors.toList()));
            print(numbersList);
            Collections.sort(numbersList);
            print(numbersList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void print(List<Integer> numberList) {
        List<String> stringVersionOfNumberList = new ArrayList<>();
        for (Integer integer : numberList) {
            stringVersionOfNumberList.add(String.valueOf(integer));
        }
        System.out.println(String.join(", ", stringVersionOfNumberList));
    }

}
