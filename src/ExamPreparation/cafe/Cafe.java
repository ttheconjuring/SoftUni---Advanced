package ExamPreparation.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {

    private List<Employee> employees;
    private String name;
    private int capacity;

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getCount() {
        return getEmployees().size();
    }

    public Cafe(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        setEmployees(new ArrayList<>());
    }

    public void addEmployee(Employee employee) {
        if (getEmployees().size() < getCapacity()) {
            getEmployees().add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : getEmployees()) {
            if (employee.getName().equals(name)) {
                getEmployees().remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        Employee oldest = getEmployees().get(0);
        for (Employee employee : getEmployees()) {
            if (employee.getAge() > oldest.getAge()) {
                oldest = employee;
            }
        }
        return oldest;
    }

    public Employee getEmployee(String name) {
        for (Employee employee : getEmployees()) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Employees working at Cafe ").append(getName()).append(":").append(System.lineSeparator());
        for (Employee employee : getEmployees()) {
            report.append(employee).append(System.lineSeparator());
        }
        return report.toString();
    }

}
