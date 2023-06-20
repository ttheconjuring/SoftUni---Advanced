package GenericsExercise.Tuple;

public class Tuple<T, K> {

    private T item1;
    private K item2;

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public K getItem2() {
        return item2;
    }

    public void setItem2(K item2) {
        this.item2 = item2;
    }

    public Tuple(T item1, K item2) {
        setItem1(item1);
        setItem2(item2);
    }

}
