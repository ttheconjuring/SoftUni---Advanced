package JAVA_OOP.WorkingWithAbstractionLab.HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputArray = bufferedReader.readLine().split(" ");
            double pricePerDay = Double.parseDouble(inputArray[0]);
            int numberOfDays = Integer.parseInt(inputArray[1]);
            String season = inputArray[2];
            String discountType = inputArray[3];
            PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, numberOfDays, season, discountType);
            System.out.printf("%.2f", priceCalculator.calculate());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
