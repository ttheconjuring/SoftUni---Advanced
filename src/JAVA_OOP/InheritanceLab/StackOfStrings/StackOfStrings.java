package JAVA_OOP.InheritanceLab.StackOfStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        setData(new ArrayList<>());
    }

    public List<String> getData() {
        return Collections.unmodifiableList(this.data);
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void push(String item) {
        this.data.add(0, item);
    }

    public String pop() {
        String removedElement = this.data.get(0);
        this.data.remove(0);
        return removedElement;
    }

    public String peek() {
        return this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.size() == 0;
    }

}
