package GenericsExercise.GenericCountMethodDouble;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

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
    public int compareTo(Box<T> o) {
        return Integer.compare(getValue().compareTo(o.getValue()), 0);
    }
}
