package JAVA_OOP.EncapsulationExercise.ClassBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            double length = Double.parseDouble(bufferedReader.readLine());
            double width = Double.parseDouble(bufferedReader.readLine());
            double height = Double.parseDouble(bufferedReader.readLine());
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.calculateSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.calculateVolume());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
