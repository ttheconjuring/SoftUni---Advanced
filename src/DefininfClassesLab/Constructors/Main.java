package DefininfClassesLab.Constructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String[] carInfoArray = bufferedReader.readLine().split(" ");
                if (carInfoArray.length == 1) {
                    Car car = new Car(carInfoArray[0]);
                    car.carInfo();
                } else {
                    Car car = new Car(carInfoArray[0], carInfoArray[1], Integer.parseInt(carInfoArray[2]));
                    car.carInfo();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
