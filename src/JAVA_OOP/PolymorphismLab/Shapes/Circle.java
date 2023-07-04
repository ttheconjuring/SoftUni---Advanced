package JAVA_OOP.PolymorphismLab.Shapes;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.setPerimeter(this.calculatePerimeter());
        this.setArea(this.calculateArea());
    }

    public final Double getRadius() {
        return radius;
    }

    private void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }
}
