package JAVA_OOP.PolymorphismLab.Shapes;

public class Main {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(2D, 4D);
        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
        Circle circle = new Circle(8D);
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());

    }

}
