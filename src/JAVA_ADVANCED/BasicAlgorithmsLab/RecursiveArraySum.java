package BasicAlgorithmsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecursiveArraySum {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(sum(array, 0));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int sum(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }
        return array[index] + sum(array, index + 1);
    }

}
