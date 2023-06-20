package WorkshopLab.CustomStack;

import java.util.function.Consumer;

public class CustomStack {

    private int[] items;
    private int size;
    private static final int INITIAL_CAPACITY = 4;
    private int capacity;

    public int[] getItems() {
        return items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CustomStack() {
        setItems(new int[INITIAL_CAPACITY]);
        setSize(0);
        setCapacity(INITIAL_CAPACITY);
    }


    // ==============================================

    public void push(int element) {
        if (getSize() == getCapacity()) {
            resize();
        }
        getItems()[getSize()] = element;
        setSize(getSize() + 1);
    }

    public int pop() {
        if (getSize() > 0) {
            int lastElement = getItems()[getSize() - 1];
            getItems()[getSize() - 1] = 0;
            setSize(getSize() - 1);
            if (getSize() >= 4) {
                if (getSize() * 4 == getCapacity()) {
                    shrink();
                }
            }
            return lastElement;
        } else {
            try {
                throw new NoSuchFieldException("Empty stack");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int peek() {
        if (getSize() > 0) {
            return getItems()[getSize() - 1];
        } else {
            try {
                throw new NoSuchFieldException("Empty stack");
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = getSize() - 1; i >= 0; i--) {
            consumer.accept(getItems()[i]);
        }
    }

    // ==============================================

    private void resize() {
        int[] resizedArray = new int[getCapacity() * 2];
        for (int i = 0; i < getSize(); i++) {
            resizedArray[i] = getItems()[i];
        }
        setItems(resizedArray);
        setCapacity(getCapacity() * 2);
    }

    private void shrink() {
        int[] resizedArray = new int[getCapacity() / 2];
        for (int i = 0; i < getSize(); i++) {
            resizedArray[i] = getItems()[i];
        }
        setItems(resizedArray);
        setCapacity(getCapacity() / 2);
    }

    // ==============================================

}
