package IteratorAndComparatorsExercise.Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Lake lake = new Lake(Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray());
            String end = bufferedReader.readLine();
            StringBuilder sb = new StringBuilder();
            Iterator<Integer> lakeIterator = lake.iterator();
            while (lakeIterator.hasNext()) {
                sb.append(lakeIterator.next()).append(", ");
                lake.setIndex(lake.getIndex() + 2);
            }
            lake.setIndex(1);
            while (lakeIterator.hasNext()) {
                sb.append(lakeIterator.next()).append(", ");
                lake.setIndex(lake.getIndex() + 2);
            }
            sb.deleteCharAt(sb.length() - 2);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
