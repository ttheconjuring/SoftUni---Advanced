package IteratorAndComparatorsExercise.ListyIterator;

import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator<T> {

    private List<T> list;
    private int index = 0;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @SafeVarargs
    public ListyIterator(T... elements) {
        setList(List.of(elements));
        setIndex(0);
    }

    public boolean move() {
        if (getIndex() < getList().size() - 1) {
            setIndex(getIndex() + 1);
            return true;
        }
        return false;
    }

    public void print() {
        if (!getList().isEmpty()) {
            System.out.println(getList().get(getIndex()));
        } else {
            throw new NoSuchElementException("Invalid Operation!");
        }
    }

    public boolean hasNext() {
        if (getIndex() < getList().size() - 1) {
            return true;
        }
        return false;
    }
    
}
