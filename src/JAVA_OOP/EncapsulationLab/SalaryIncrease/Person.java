package JAVA_OOP.EncapsulationLab.SalaryIncrease;

import java.text.DecimalFormat;

public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), new DecimalFormat("#.0###").format(this.getSalary()));
    }

    public void increaseSalary(double bonusInPercentages) {
        double bonusInBGN = this.getSalary() * bonusInPercentages / 100;
        if (this.getAge() >= 30) {
            setSalary(this.getSalary() + bonusInBGN);
        } else {
            setSalary(this.getSalary() + (bonusInBGN / 2));
        }
    }

}
