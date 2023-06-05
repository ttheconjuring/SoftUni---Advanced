package GenericsExercise.GenericSwapMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Box<String>> boxes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Box<String> box = new Box<>(bufferedReader.readLine());
                boxes.add(box);
            }
            int[] indexes = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int firstIndex = indexes[0];
            int secondIndex = indexes[1];

            swap(boxes, firstIndex, secondIndex);
            boxes.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static <T> void swap(List<T> arrayList, int firstIndex, int secondIndex) {
        T firstElement = arrayList.get(firstIndex);
        T secondElement = arrayList.get(secondIndex);
        arrayList.set(firstIndex, secondElement);
        arrayList.set(secondIndex, firstElement);
    }

}
