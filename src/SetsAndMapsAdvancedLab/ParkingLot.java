package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] inputArray = input.split(",\\s+");
            switch (inputArray[0]) {
                case "IN":
                    carNumbers.add(inputArray[1]);
                    break;
                case "OUT":
                    carNumbers.remove(inputArray[1]);
                    break;
            }
            input = scanner.nextLine();
        }

        if(!carNumbers.isEmpty()) {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }

        scanner.close();
    }

}
