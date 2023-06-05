package GenericsExercise.GenericCountMethodString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Box<String>> boxes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Box<String> box = new Box<>(bufferedReader.readLine());
                boxes.add(box);
            }
            Box<String> value = new Box<>(bufferedReader.readLine());
            System.out.println(counter(boxes, value));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static <T extends Comparable<T>> int counter(List<T> arrayList, T value) {
        AtomicInteger counter = new AtomicInteger();
        arrayList.forEach(box -> {
            if (box.compareTo(value) > 0) {
                counter.getAndIncrement();
            }
        });
        return counter.get();
    }

}
