package ExamPreparation.shelter;

public class Animal {

    private String name;
    private int age;
    private String caretaker;

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

    public String getCaretaker() {
        return caretaker;
    }

    public void setCaretaker(String caretaker) {
        this.caretaker = caretaker;
    }

    public Animal(String name, int age, String caretaker) {
        setName(name);
        setAge(age);
        setCaretaker(caretaker);
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", getName(), getAge(), getCaretaker());
    }

}
