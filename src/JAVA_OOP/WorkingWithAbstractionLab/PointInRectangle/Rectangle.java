package JAVA_OOP.PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        setBottomLeft(bottomLeft);
        setTopRight(topRight);
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        return (point.getX() >= getBottomLeft().getX() && point.getX() <= getTopRight().getX()) && (point.getY() >= getBottomLeft().getY() && point.getY() <= getTopRight().getY());
    }

}
