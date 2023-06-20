package GenericsExercise.CustomListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> arrayList;

    public List<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(List<T> arrayList) {
        this.arrayList = arrayList;
    }

    public CustomList() {
        setArrayList(new ArrayList<>());
    }

    public void add(T element) {
        getArrayList().add(element);
    }

    public T remove(int index) {
        if (getArrayList().size() > 0) {
            return getArrayList().remove(index);
        }
        return null;
    }

    public boolean contains(T element) {
        if (getArrayList().size() > 0) {
            return getArrayList().contains(element);
        }
        return false;
    }

    public void swap(int index1, int index2) {
        T firstElement = getArrayList().get(index1);
        T secondElement = getArrayList().get(index2);
        getArrayList().set(index1, secondElement);
        getArrayList().set(index2, firstElement);
    }

    public int countGreaterThan(T element) {
        int counter = 0;
        for (T t : getArrayList()) {
            if (t.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T max = getArrayList().get(0);
        for (T t : getArrayList()) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    public T getMin() {
        T min = getArrayList().get(0);
        for (T t : getArrayList()) {
            if (t.compareTo(min) < 0) {
                min = t;
            }
        }
        return min;
    }

    public void forEaech(Consumer<T> consumer) {
        getArrayList().forEach(consumer);
    }

    public T get(int index) {
        if (index >= 0 && index < getArrayList().size()) {
            return getArrayList().get(index);
        }
        return null;
    }

    public int getSize() {
        return getArrayList().size();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < getArrayList().size();
            }

            @Override
            public T next() {
                return getArrayList().get(this.index++);
            }
        };
    }
}
