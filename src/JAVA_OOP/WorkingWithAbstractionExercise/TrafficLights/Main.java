package JAVA_OOP.WotkingWithAbstractionExercise.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            TrafficLights[] trafficLights = Arrays.stream(bufferedReader.readLine().split(" ")).map(color -> new TrafficLights(Colors.valueOf(color))).toArray(TrafficLights[]::new);
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                Arrays.stream(trafficLights).forEach(trafficLight -> {
                    trafficLight.update();
                    System.out.print(trafficLight.getCurrentColor() + " ");
                });
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
