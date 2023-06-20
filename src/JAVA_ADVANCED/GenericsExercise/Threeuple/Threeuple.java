package GenericsExercise.Threeuple;

public class Threeuple<T, K, E> {

    private T item1;
    private K item2;
    private E item3;

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

    public E getItem3() {
        return item3;
    }

    public void setItem3(E item3) {
        this.item3 = item3;
    }

    public Threeuple(T item1, K item2, E item3) {
        setItem1(item1);
        setItem2(item2);
        setItem3(item3);
    }
}
