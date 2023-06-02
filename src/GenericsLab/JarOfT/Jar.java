package GenericsLab.JarOfT;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class Jar<T> {

    private ArrayDeque<T> stack;

    public ArrayDeque<T> getStack() {
        return stack;
    }

    public void setStack(ArrayDeque<T> stack) {
        this.stack = stack;
    }

    public Jar() {
        setStack(new ArrayDeque<>());
    }

    public void add(T element) {
        getStack().push(element);
    }

    public T remove() {
        try {
        return getStack().pop();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return null;
    }

}
