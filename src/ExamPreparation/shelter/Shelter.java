package ExamPreparation.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Animal> getData() {
        return data;
    }

    public void setData(List<Animal> data) {
        this.data = data;
    }

    public Shelter(int capacity) {
        setCapacity(capacity);
        setData(new ArrayList<>());
    }

    public void add(Animal animal) {
        if (getData().size() < getCapacity()) {
            getData().add(animal);
        }
    }

    public boolean remove(String name) {
        for (Animal datum : getData()) {
            if (datum.getName().equals(name)) {
                return getData().remove(datum);
            }
        }
        return false;
    }

    public Animal getAnimal(String name, String caretaker) {
        for (Animal datum : getData()) {
            if (datum.getName().equals(name)) {
                if (datum.getCaretaker().equals(caretaker)) {
                    return datum;
                }
            }
        }
        return null;
    }

    public Animal getOldestAnimal() {
        Animal oldestAnimal = getData().get(0);
        for (Animal datum : getData()) {
            if (datum.getAge() > oldestAnimal.getAge()) {
                oldestAnimal = datum;
            }
        }
        return oldestAnimal;
    }

    public int getCount() {
        return getData().size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The shelter has the following animals:%n"));
        getData().forEach(animal -> sb.append(String.format("%s %s%n", animal.getName(), animal.getCaretaker())));
        return sb.toString();
    }

}
