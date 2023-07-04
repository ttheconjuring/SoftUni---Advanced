package JAVA_OOP.PolymorphismLab.Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.setPerimeter(this.calculatePerimeter());
        this.setArea(this.calculateArea());
    }

    public Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * (this.getHeight() + this.getWidth());
    }

    @Override
    protected Double calculateArea() {
        return this.getHeight() * this.getWidth();
    }
}
