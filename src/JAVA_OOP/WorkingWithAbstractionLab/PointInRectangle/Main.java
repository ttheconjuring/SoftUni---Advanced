package JAVA_OOP.PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int[] rectangleCoordinatesArray = makeIntArrayFrom(bufferedReader.readLine());
            Point bottomLeft = new Point(rectangleCoordinatesArray[0], rectangleCoordinatesArray[1]);
            Point topRight = new Point(rectangleCoordinatesArray[2], rectangleCoordinatesArray[3]);
            Rectangle rectangle = new Rectangle(bottomLeft, topRight);
            int n = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                int[] pointCoordinatesArray = makeIntArrayFrom(bufferedReader.readLine());
                Point point = new Point(pointCoordinatesArray[0], pointCoordinatesArray[1]);
                System.out.println(rectangle.contains(point));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int[] makeIntArrayFrom(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

}
