package ExamPreparation.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private String name;
    private int capacity;
    private List<Person> roster;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Person> getRoster() {
        return roster;
    }

    public void setRoster(List<Person> roster) {
        this.roster = roster;
    }

    public Hotel(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        setRoster(new ArrayList<>());
    }

    public void add(Person person) {
        if (getCount() < getCapacity()) {
            getRoster().add(person);
        }
    }

    public boolean remove(String name) {
        if (!getRoster().isEmpty()) {
            for (Person person : getRoster()) {
                if (person.getName().equals(name)) {
                    return getRoster().remove(person);
                }
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        if (!getRoster().isEmpty()) {
            for (Person person : getRoster()) {
                if (person.getName().equals(name)) {
                    if (person.getHometown().equals(hometown)) {
                        return person;
                    }
                }
            }
        }
        return null;
    }

    public int getCount() {
        return getRoster().size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", getName()));
        getRoster().forEach(person -> sb.append(String.format("%s%n", person)));
        return sb.toString();
    }

}
