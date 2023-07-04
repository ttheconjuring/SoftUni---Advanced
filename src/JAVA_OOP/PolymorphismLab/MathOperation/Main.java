package JAVA_OOP.PolymorphismLab.MathOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            MathOperation math = new MathOperation();
            System.out.println(math.add(2, 2));
            System.out.println(math.add(3, 3, 3));
            System.out.println(math.add(4, 4, 4, 4));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
