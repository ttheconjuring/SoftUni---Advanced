package DefiningClassesExercise.SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Car[] carArray = new Car[n];
            for (int i = 0; i < n; i++) {
                String[] inputArray = bufferedReader.readLine().split(" ");
                String model = inputArray[0];
                double fuelAmount = Double.parseDouble(inputArray[1]);
                double fuelCostFor1Km = Double.parseDouble(inputArray[2]);
                carArray[i] = new Car(model, fuelAmount, fuelCostFor1Km);
            }
            String command = bufferedReader.readLine();
            while (!command.equals("End")) {
                String[] inputArray = command.split(" ");
                String model = inputArray[1];
                int amountOfKilometers = Integer.parseInt(inputArray[2]);
                for (int i = 0; i < n; i++) {
                    if (carArray[i].getModel().equals(model)) {
                        if (carArray[i].theMaximumDistanceACarCanTravel() >= amountOfKilometers) {
                            carArray[i].setFuelAmount(carArray[i].getFuelAmount() - (amountOfKilometers * carArray[i].getFuelCostFor1Kilometer()));
                            carArray[i].setDistanceTravelled(carArray[i].getDistanceTravelled() + amountOfKilometers);
                        } else {
                            System.out.println("Insufficient fuel for the drive");
                        }
                    }
                }
                command = bufferedReader.readLine();
            }
            for (int i = 0; i < n; i++) {
                System.out.println(carArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
