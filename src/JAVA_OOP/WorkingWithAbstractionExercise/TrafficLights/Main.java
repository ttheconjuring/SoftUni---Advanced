package JAVA_OOP.WotkingWithAbstractionExercise.TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] trafficLightsStringArray = bufferedReader.readLine().split(" ");
            TrafficLights[] trafficLights = new TrafficLights[trafficLightsStringArray.length];
            for (int i = 0; i < trafficLightsStringArray.length; i++) {
                trafficLights[i] = new TrafficLights(Colors.valueOf(trafficLightsStringArray[i]));
            }
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < trafficLights.length; j++) {
                    trafficLights[j].update();
                    System.out.print(trafficLights[j].getCurrentColor() + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
