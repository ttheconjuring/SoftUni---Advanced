package JAVA_OOP.InterfacesAndAbstractionLab.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(new Ferrari(bufferedReader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
