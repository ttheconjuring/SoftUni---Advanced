package JAVA_OOP.PolymorphismExercise.VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] carInfoArray = bufferedReader.readLine().split(" ");
            Car car = new Car(Double.parseDouble(carInfoArray[1]), Double.parseDouble(carInfoArray[2]), Double.parseDouble(carInfoArray[3]));
            String[] truckInfoArray = bufferedReader.readLine().split(" ");
            Truck truck = new Truck(Double.parseDouble(truckInfoArray[1]), Double.parseDouble(truckInfoArray[2]), Double.parseDouble(truckInfoArray[3]));
            String[] busInfoArray = bufferedReader.readLine().split(" ");
            Bus bus = new Bus(Double.parseDouble(busInfoArray[1]), Double.parseDouble(busInfoArray[2]), Double.parseDouble(busInfoArray[3]));
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String[] commandArray = bufferedReader.readLine().split(" ");
                try {
                    switch (commandArray[0]) {
                        case "Drive":
                            switch (commandArray[1]) {
                                case "Car":
                                    drive(car, Double.parseDouble(commandArray[2]));
                                    break;
                                case "Truck":
                                    drive(truck, Double.parseDouble(commandArray[2]));
                                    break;
                                case "Bus":
                                    bus.setBusIsEmpty(false);
                                    drive(bus, Double.parseDouble(commandArray[2]));
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
                                case "Bus":
                                    refuel(bus, Double.parseDouble(commandArray[2]));
                                    break;
                            }
                            break;
                        case "DriveEmpty":
                            bus.setBusIsEmpty(true);
                            drive(bus, Double.parseDouble(commandArray[2]));
                            break;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.printf("Car: %.2f\n", car.getFuelQuantity());
            System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
            System.out.printf("Bus: %.2f\n", bus.getFuelQuantity());
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
