package IteratorAndComparatorsExercise.ComparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Person(String name, int age, String town) {
        setName(name);
        setAge(age);
        setTown(town);
    }

    @Override
    public int compareTo(Person o) {
        int result = getName().compareTo(o.getName());
        if (result == 0) {
            result = Integer.compare(getAge(), o.getAge());
            if (result == 0) {
                result = getTown().compareTo(o.getTown());
            }
        }
        return result;
    }
}
