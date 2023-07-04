package JAVA_OOP.PolymorphismLab.Shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Rectangle rectangle = new Rectangle(2D, 4D);
            System.out.println(rectangle.calculatePerimeter());
            System.out.println(rectangle.calculateArea());
            Circle circle = new Circle(8D);
            System.out.println(circle.calculatePerimeter());
            System.out.println(circle.calculateArea());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
