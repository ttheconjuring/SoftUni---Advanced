package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class RubberDuckDebuggers {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> timeQueue = new ArrayDeque<>();
            int[] timeSequence = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
            for (int i = 0; i < timeSequence.length; i++) {
                timeQueue.offer(timeSequence[i]);
            }
            int[] task = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < task.length; i++) {
                tasksStack.push(task[i]);
            }
            int darthVaderDucky = 0;
            int thorDucky = 0;
            int bigBlueRubberDucky = 0;
            int smallYellowRubberDucky = 0;
            while (!timeQueue.isEmpty() && !tasksStack.isEmpty()) {
                int product = timeQueue.peek() * tasksStack.peek();
                if (product >= 0 && product <= 60) {
                    darthVaderDucky++;
                    timeQueue.poll();
                    tasksStack.pop();
                } else if (product <= 120) {
                    thorDucky++;
                    timeQueue.poll();
                    tasksStack.pop();
                } else if (product <= 180) {
                    bigBlueRubberDucky++;
                    timeQueue.poll();
                    tasksStack.pop();
                } else if (product <= 240) {
                    smallYellowRubberDucky++;
                    timeQueue.poll();
                    tasksStack.pop();
                } else {
                    int decreasedTaskValue = tasksStack.pop() - 2;
                    tasksStack.push(decreasedTaskValue);
                    int timeValue = timeQueue.poll();
                    timeQueue.offer(timeValue);
                }
            }
            System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
            System.out.println("Darth Vader Ducky: " + darthVaderDucky);
            System.out.println("Thor Ducky: " + thorDucky);
            System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDucky);
            System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucky);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
