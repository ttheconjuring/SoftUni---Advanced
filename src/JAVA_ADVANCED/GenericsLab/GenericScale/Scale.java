package GenericsLab.GenericScale;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public T getLeft() {
        return left;
    }

    public void setLeft(T left) {
        this.left = left;
    }

    public T getRight() {
        return right;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public Scale(T left, T right) {
        setLeft(left);
        setRight(right);
    }

    public T getHeavier() {
        int result = left.compareTo(right);
        if (result < 0) {
            return right;
        } else if (result > 0) {
            return left;
        }
        return null;
    }

}
