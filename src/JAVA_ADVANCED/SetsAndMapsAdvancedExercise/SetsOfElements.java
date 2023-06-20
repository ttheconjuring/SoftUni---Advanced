package SetsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> nSet = new LinkedHashSet<>();

        for (int i = 0; i < sizes[0]; i++) {
            nSet.add(Integer.parseInt(scanner.nextLine()));
        }

        Set<Integer> mSet = new LinkedHashSet<>();
        for (int i = 0; i < sizes[1]; i++) {
            mSet.add(Integer.parseInt(scanner.nextLine()));
        }

        nSet.retainAll(mSet);

        for (Integer integer : nSet) {
            System.out.print(integer + " ");
        }

        scanner.close();
    }

}
