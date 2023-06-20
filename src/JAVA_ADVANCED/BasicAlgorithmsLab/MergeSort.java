package BasicAlgorithmsLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] array = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mergeSort(array);
            for (int i : array) {
                System.out.print(i + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void mergeSort(int[] array) {
        if (array.length == 1) {
            return;
        }
        int halfIndex = array.length / 2;
        int secondArrayLength = array.length - halfIndex;
        int[] firstPartition = new int[halfIndex];
        int[] secondPartition = new int[secondArrayLength];
        for (int i = 0; i < halfIndex; i++) {
            firstPartition[i] = array[i];
        }
        for (int i = halfIndex; i < halfIndex + secondArrayLength; i++) {
            secondPartition[i - halfIndex] = array[i];
        }
        mergeSort(firstPartition);
        mergeSort(secondPartition);
        int mainIndex = 0;
        int firstPartitionIndex = 0;
        int secondPartitionIndex = 0;
        while (firstPartitionIndex < halfIndex && secondPartitionIndex < secondArrayLength) {
            if (firstPartition[firstPartitionIndex] < secondPartition[secondPartitionIndex]) {
                array[mainIndex] = firstPartition[firstPartitionIndex];
                mainIndex++;
                firstPartitionIndex++;
            } else {
                array[mainIndex] = secondPartition[secondPartitionIndex];
                mainIndex++;
                secondPartitionIndex++;
            }
        }
        while (firstPartitionIndex < halfIndex) {
            array[mainIndex] = firstPartition[firstPartitionIndex];
            mainIndex++;
            firstPartitionIndex++;
        }
        while (secondPartitionIndex < secondArrayLength) {
            array[mainIndex] = secondPartition[secondPartitionIndex];
            mainIndex++;
            secondPartitionIndex++;
        }
    }

}
