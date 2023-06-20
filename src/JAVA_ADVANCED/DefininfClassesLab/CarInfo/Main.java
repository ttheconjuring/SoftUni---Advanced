package DefininfClassesLab.CarInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                String[] carInfoArray = bufferedReader.readLine().split(" ");
                Car car = new Car();
                car.setBrand(carInfoArray[0]);
                car.setModel(carInfoArray[1]);
                car.setHorsePower(Integer.parseInt(carInfoArray[2]));
                car.carInfo();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
