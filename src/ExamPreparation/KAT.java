package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class KAT {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
            int[] licensePlates = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < licensePlates.length; i++) {
                licensePlatesQueue.offer(licensePlates[i]);
            }
            ArrayDeque<Integer> carsQueue = new ArrayDeque<>();
            int[] cars = Arrays.stream(bufferedReader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int i = cars.length - 1; i >= 0; i--) {
                carsQueue.offer(cars[i]);
            }
            int registeredCars = 0;
            int days = 0;
            while (!licensePlatesQueue.isEmpty() && !carsQueue.isEmpty()) {
                int carsThatCanBeRegistered = licensePlatesQueue.peek() / 2;
                if (carsThatCanBeRegistered < carsQueue.peek()) {
                    int waitingCars = carsQueue.poll() - carsThatCanBeRegistered;
                    licensePlatesQueue.poll();
                    registeredCars += carsThatCanBeRegistered;
                    carsQueue.offer(waitingCars);
                } else if (carsThatCanBeRegistered > carsQueue.peek()) {
                    int licencePlatesNeeded = carsQueue.peek() * 2;
                    int leftLicencePlates = licensePlatesQueue.poll() - licencePlatesNeeded;
                    licensePlatesQueue.offer(leftLicencePlates);
                    registeredCars += carsQueue.poll();
                } else {
                    licensePlatesQueue.poll();
                    registeredCars += carsQueue.poll();
                }
                days++;
            }
            System.out.println(registeredCars + " cars were registered for " + days + " days!");
            if (!licensePlatesQueue.isEmpty()) {
                System.out.println(licensePlatesQueue.stream().mapToInt(value -> value).sum() + " license plates remain!");
            }
            if (!carsQueue.isEmpty()) {
                System.out.println(carsQueue.stream().mapToInt(value -> value).sum() + " cars remain without license plates!");
            }
            if (licensePlatesQueue.isEmpty()) {
                if (carsQueue.isEmpty()) {
                    System.out.println("Good job! There is no queue in front of the KAT!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
