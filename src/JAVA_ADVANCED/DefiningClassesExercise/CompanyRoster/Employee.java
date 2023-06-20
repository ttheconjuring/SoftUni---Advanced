package DefiningClassesExercise.CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail("n/a");
        setAge(-1);
    }

    public Employee(String name, double salary, String position, String department, String email) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail(email);
        setAge(-1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail("n/a");
        setAge(age);
    }

    public Employee(String name, double salary, String position, String department, String email, int age) {
        setName(name);
        setSalary(salary);
        setPosition(position);
        setDepartment(department);
        setEmail(email);
        setAge(age);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }

}
