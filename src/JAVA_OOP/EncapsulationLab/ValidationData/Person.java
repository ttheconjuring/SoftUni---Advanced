package JAVA_OOP.EncapsulationLab.ValidationData;

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
        if (firstName.length() < 3) {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    private void setSalary(double salary) {
        if (salary < 460) {
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
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
