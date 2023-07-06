package JAVA_OOP.PolymorphismExercise.Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] carInfoArray = bufferedReader.readLine().split(" ");
            Car car = new Car(Double.parseDouble(carInfoArray[1]), Double.parseDouble(carInfoArray[2]));
            String[] truckInfoArray = bufferedReader.readLine().split(" ");
            Truck truck = new Truck(Double.parseDouble(truckInfoArray[1]), Double.parseDouble(truckInfoArray[2]));
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String[] commandArray = bufferedReader.readLine().split(" ");
                switch (commandArray[0]) {
                    case "Drive":
                        switch (commandArray[1]) {
                            case "Car":
                                drive(car, Double.parseDouble(commandArray[2]));
                                break;
                            case "Truck":
                                drive(truck, Double.parseDouble(commandArray[2]));
                                break;
                        }
                        break;
                    case "Refuel":
                        switch (commandArray[1]) {
                            case "Car":
                                refuel(car, Double.parseDouble(commandArray[2]));
                                break;
                            case "Truck":
                                refuel(truck, Double.parseDouble(commandArray[2]));
                                break;
                        }
                        break;
                }
            }
            System.out.printf("Car: %.2f\n", car.getFuelQuantity());
            System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void drive(Vehicle vehicle, double distance) {
        vehicle.drive(distance);
    }

    private static void refuel(Vehicle vehicle, double fuel) {
        vehicle.refuel(fuel);
    }

}
