package RegularExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TempleOfDoom {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> toolsQueue = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
            ArrayDeque<Integer> substancesStack = new ArrayDeque<>();
            Arrays.stream(bufferedReader.readLine().split("\\s+")).map(Integer::parseInt).forEach(substancesStack::push);
            int[] challenges = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> challengesList = new ArrayList<>();
            for (int i = 0; i < challenges.length; i++) {
                challengesList.add(challenges[i]);
            }
            while (!toolsQueue.isEmpty() && !substancesStack.isEmpty()) {
                int product = toolsQueue.peek() * substancesStack.peek();
                boolean productFound = false;
                for (Integer integer : challengesList) {
                    if (integer == product) {
                        productFound = true;
                        toolsQueue.poll();
                        substancesStack.pop();
                        challengesList.remove(integer);
                        break;
                    }
                }
                if (challengesList.isEmpty()) {
                    break;
                }
                if (!productFound) {
                    toolsQueue.offer(toolsQueue.poll() + 1);
                    int stackElement = substancesStack.pop() - 1;
                    if (stackElement > 0) {
                        substancesStack.push(stackElement);
                    }
                }
            }
            if (challengesList.isEmpty()) {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
            } else {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
            }
            if (!toolsQueue.isEmpty()) {
                System.out.println("Tools: " + toolsQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            if (!substancesStack.isEmpty()) {
                System.out.println("Substances: " + substancesStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
            if (!challengesList.isEmpty()) {
                System.out.println("Challenges: " + challengesList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
