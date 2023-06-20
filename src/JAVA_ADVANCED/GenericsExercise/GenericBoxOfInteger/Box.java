package GenericsExercise.GenericBoxOfInteger;

public class Box<T> {

    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Box(T value) {
        setValue(value);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getValue().getClass().getName(), getValue());
    }

}
