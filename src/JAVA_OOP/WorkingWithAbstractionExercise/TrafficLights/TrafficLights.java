package JAVA_OOP.WotkingWithAbstractionExercise.TrafficLights;

public class TrafficLights {

    private Colors currentColor;

    public TrafficLights(Colors color) {
        setCurrentColor(color);
    }

    public Colors getCurrentColor() {
        return currentColor;
    }

    private void setCurrentColor(Colors currentColor) {
        this.currentColor = currentColor;
    }

    public void update() {
        if (currentColor == Colors.RED) {
            setCurrentColor(Colors.GREEN);
        } else if (currentColor == Colors.GREEN) {
            setCurrentColor(Colors.YELLOW);
        } else {
            setCurrentColor(Colors.RED);
        }
    }
}
