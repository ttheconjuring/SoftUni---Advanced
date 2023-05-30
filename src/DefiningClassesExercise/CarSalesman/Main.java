package DefiningClassesExercise.CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Engine[] enginesArray = new Engine[n];
            for (int i = 0; i < n; i++) {
                Engine engine = new Engine();
                String[] inputArray = bufferedReader.readLine().split(" ");
                String model = inputArray[0];
                String power = inputArray[1];
                switch (inputArray.length) {
                    case 3:
                        engine = new Engine(model, power);
                        String optional = inputArray[2];
                        if (optional.matches("\\d+")) {
                            engine.setDisplacement(optional);
                        } else {
                            engine.setEfficiency(optional);
                        }
                        break;
                    case 4:
                        String displacement = inputArray[2];
                        String efficiency = inputArray[3];
                        engine = new Engine(model, power, displacement, efficiency);
                        break;
                    default:
                        engine = new Engine(model, power);
                }
                enginesArray[i] = engine;
            }
            int m = Integer.parseInt(bufferedReader.readLine());
            Car[] carsArray = new Car[m];
            for (int i = 0; i < m; i++) {
                Car car = new Car();
                String[] inputArray = bufferedReader.readLine().split(" ");
                String model = inputArray[0];
                Engine engine = new Engine();
                for (int j = 0; j < n; j++) {
                    if (enginesArray[j].getModel().equals(inputArray[1])) {
                        engine = enginesArray[j];
                    }
                }
                switch (inputArray.length) {
                    case 3:
                        car = new Car(model, engine);
                        String optional = inputArray[2];
                        if (optional.matches("\\d+")) {
                            car.setWeight(optional);
                        } else {
                            car.setColor(optional);
                        }
                        break;
                    case 4:
                        String weight = inputArray[2];
                        String color = inputArray[3];
                        car = new Car(model, engine, weight, color);
                        break;
                    default:
                        car = new Car(model, engine);
                }
                carsArray[i] = car;
            }
            for (int i = 0; i < m; i++) {
                System.out.print(carsArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
