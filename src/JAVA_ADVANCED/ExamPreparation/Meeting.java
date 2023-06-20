package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Meeting {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> malesStack = new ArrayDeque<>();
            int[] males = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < males.length; i++) {
                malesStack.push(males[i]);
            }
            ArrayDeque<Integer> femalesQueue = new ArrayDeque<>();
            int[] females = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < females.length; i++) {
                femalesQueue.offer(females[i]);
            }
            int matches = 0;
            while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
                int firstMale = malesStack.peek();
                int firstFemale = femalesQueue.peek();
                if (firstMale <= 0) {
                    malesStack.pop();
                    continue;
                }
                if (firstFemale <= 0) {
                    femalesQueue.poll();
                    continue;
                }
                if (firstMale % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                    continue;
                }
                if (firstFemale % 25 == 0) {
                    femalesQueue.poll();
                    femalesQueue.poll();
                    continue;
                }
                if (firstMale == firstFemale) {
                    matches++;
                    malesStack.pop();
                    femalesQueue.poll();
                } else {
                    femalesQueue.poll();
                    malesStack.push(malesStack.pop() - 2);
                }
            }
            System.out.println("Matches: " + matches);
            if (malesStack.isEmpty()) {
                System.out.println("Males left: none");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Males left: ");
                while (!malesStack.isEmpty()) {
                    sb.append(malesStack.pop()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
            if (femalesQueue.isEmpty()) {
                System.out.println("Females left: none");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Females left: ");
                while (!femalesQueue.isEmpty()) {
                    sb.append(femalesQueue.poll()).append(", ");
                }
                sb.deleteCharAt(sb.length() - 2);
                System.out.println(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
