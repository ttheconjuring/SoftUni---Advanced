package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class LargestThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(TreeSet::new));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer number : numbers) {
            stack.push(number);
        }
        if(numbers.size() < 3) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.print(stack.pop() + " ");
            }
        }

        scanner.close();
    }

}
