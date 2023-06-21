package JAVA_OOP.WorkingWithAbstractionLab.StudentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StudentSystem studentSystem = new StudentSystem();
            String[] input = makeStringArrayFrom(bufferedReader.readLine());
            while (!input[0].equals("Exit")) {
                studentSystem.ParseCommand(input);
                input = makeStringArrayFrom(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] makeStringArrayFrom(String input) {
        return input.split(" ");
    }

}
