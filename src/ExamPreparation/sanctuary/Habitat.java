package ExamPreparation.sanctuary;

import java.util.ArrayList;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Elephant> getData() {
        return data;
    }

    public void setData(List<Elephant> data) {
        this.data = data;
    }

    public Habitat(int capacity) {
        setCapacity(capacity);
        setData(new ArrayList<>());
    }

    public void add(Elephant elephant) {
        if (getAllElephants() < getCapacity()) {
            getData().add(elephant);
        }
    }

    public boolean remove(String name) {
        if (!getData().isEmpty()) {
            for (Elephant elephant : getData()) {
                if (elephant.getName().equals(name)) {
                    return getData().remove(elephant);
                }
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom) {
        if (!getData().isEmpty()) {
            for (Elephant elephant : getData()) {
                if (elephant.getRetiredFrom().equals(retiredFrom)) {
                    return elephant;
                }
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        if (!getData().isEmpty()) {
            Elephant oldestElephant = getData().get(0);
            for (Elephant elephant : getData()) {
                if (elephant.getAge() > oldestElephant.getAge()) {
                    oldestElephant = elephant;
                }
            }
            return oldestElephant;
        }
        return null;
    }

    public int getAllElephants() {
        return getData().size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Saved elephants in the park:%n"));
        getData().forEach(elephant -> sb.append(String.format("%s came from: %s%n", elephant.getName(), elephant.getRetiredFrom())));
        return sb.toString();
    }

}
