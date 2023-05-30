package WorkshopLab.SmartArray;

public class SmartArray {

    private int[] data;
    private int size;
    private int capacity = 4;

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
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

    public SmartArray() {
        setData(new int[4]);
        setSize(0);
        setCapacity(4);
    }

    // ==================================================

    public void add(int element) {
        if (getSize() < getCapacity()) {
            getData()[getSize()] = element;
            setSize(getSize() + 1);
        } else {
            resize();
            getData()[getSize()] = element;
            setSize(getSize() + 1);
            setCapacity(getData().length);
        }
    }

    public int get(int index) {
        if ((getSize() != 0) && (index >= 0 && index <= getSize() - 1)) {
            return getData()[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + getSize() + "(p)");
        }
    }

    public int remove(int index) {
        if ((getSize() != 0) && (index >= 0 && index <= getSize() - 1)) {
            int result = getData()[index];
            shiftLeft(index);
            setSize(getSize() - 1);
            if (getSize() * 4 <= getCapacity()) {
                shrink();
                setCapacity(getCapacity() / 2);
            }
            getData()[getSize()] = 0;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + getSize() + "(p)");
        }
    }

    public boolean contains(int element) {
        if (getSize() != 0) {
            for (int i = 0; i < getSize(); i++) {
                if (getData()[i] == element) {
                    return true;
                }
            }
        }
        return false;
    }

    // ==================================================

    private void resize() {
        int newCapacity = getCapacity() * 2;
        int[] newDataArray = new int[newCapacity];
        fillTheNewDataArray(newDataArray);
        setData(newDataArray);
    }

    private void shrink() {
        int newCapacity = getCapacity() / 2;
        int[] newDataArray = new int[newCapacity];
        fillTheNewDataArray(newDataArray);
        setData(newDataArray);
    }

    private void shiftLeft(int index) {
        for (int i = index; i < getSize() - 1; i++) {
            getData()[i] = getData()[i + 1];
        }
    }

    // ==================================================

    private void fillTheNewDataArray(int[] newDataArray) {
        for (int i = 0; i < getSize(); i++) {
            newDataArray[i] = getData()[i];
        }
    }

}
