package IteratorAndComparatorsExercise.Froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] array;
    private int index = 0;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Lake(int... elements) {
        setArray(elements);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return getIndex() < getArray().length;
        }

        @Override
        public Integer next() {
            return getArray()[getIndex()];
        }
    }

}
