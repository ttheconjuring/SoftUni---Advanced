package IteratorAndComparatorsExercise.StackIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStack<Integer> implements Iterable<Integer> {

    private Integer[] array;
    private int index;

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public CustomStack() {
        setArray((Integer[]) new Object[16]);
        setIndex(0);
    }

    public void push(Integer element) {
        getArray()[getIndex()] = element;
        setIndex(getIndex() + 1);
    }

    public Integer pop() {
        if (getIndex() > 0) {
            setIndex(getIndex() - 1);
            Integer pop = getArray()[getIndex()];
            getArray()[getIndex()] = null;
            return pop;
        }
        throw new NoSuchElementException("No elements");
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private final class CustomIterator implements Iterator<Integer> {

        private int insideIndex = getIndex();

        public int getInsideIndex() {
            return insideIndex;
        }

        public void setInsideIndex(int insideIndex) {
            this.insideIndex = insideIndex;
        }

        @Override
        public boolean hasNext() {
            return insideIndex > 0;
        }

        @Override
        public Integer next() {
            setInsideIndex(getInsideIndex() - 1);
            return getArray()[getInsideIndex()];
        }
    }

}
