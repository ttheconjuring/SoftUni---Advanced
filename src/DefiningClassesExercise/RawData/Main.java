package DefiningClassesExercise.RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Car[] carsArray = new Car[n];
            for (int i = 0; i < n; i++) {
                String[] inputArray = bufferedReader.readLine().split(" ");
                String model = inputArray[0];
                int engineSpeed = Integer.parseInt(inputArray[1]);
                int enginePower = Integer.parseInt(inputArray[2]);
                Engine engine = new Engine(engineSpeed, enginePower);
                int cargoWeight = Integer.parseInt(inputArray[3]);
                String cargoType = inputArray[4];
                Cargo cargo = new Cargo(cargoWeight, cargoType);
                double tire1Pressure = Double.parseDouble(inputArray[5]);
                int tire1Age = Integer.parseInt(inputArray[6]);
                double tire2Pressure = Double.parseDouble(inputArray[7]);
                int tire2Age = Integer.parseInt(inputArray[8]);
                double tire3Pressure = Double.parseDouble(inputArray[9]);
                int tire3Age = Integer.parseInt(inputArray[10]);
                double tire4Pressure = Double.parseDouble(inputArray[11]);
                int tire4Age = Integer.parseInt(inputArray[12]);
                Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
                Car car = new Car(model, engine, cargo, tire);
                carsArray[i] = car;
            }
            String cargoType = bufferedReader.readLine();
            switch (cargoType) {
                case "fragile":
                    for (int i = 0; i < n; i++) {
                        if(carsArray[i].getCargo().getCargoType().equals("fragile")) {
                            if(carsArray[i].getTire().hasPressureLessThan1()) {
                                System.out.println(carsArray[i].getModel());
                            }
                        }
                    }
                    break;
                case "flamable":
                    for (int i = 0; i < n; i++) {
                        if(carsArray[i].getCargo().getCargoType().equals("flamable")) {
                            if(carsArray[i].getEngine().getEnginePower() > 250) {
                                System.out.println(carsArray[i].getModel());
                            }
                        }
                    }
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
