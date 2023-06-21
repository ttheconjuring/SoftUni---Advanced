package JAVA_OOP.WorkingWithAbstractionLab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;

    public StudentSystem() {
        setRepository(new HashMap<>());
    }

    public void setRepository(Map<String, Student> repository) {
        this.repository = repository;
    }

    public Map<String, Student> getRepository() {
        return this.repository;
    }

    public void ParseCommand(String[] input) {
        if (input[0].equals("Create")) {
            addStudent(input);
        } else {
            if (studentExists(input[1])) {
                Student student = repository.get(input[1]);
                showStudent(student);
            }
        }
    }

    private void addStudent(String[] input) {
        if (!studentExists(input[1])) {
            Student student = new Student(input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            repository.put(input[1], student);
        }
    }

    private void showStudent(Student student) {
        StringBuilder view = new StringBuilder();
        view.append(student.getName()).append(" is ").append(student.getAge()).append(" years old.");
        if (student.getGrade() >= 5.00) {
            view.append(" Excellent student.");
        } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
            view.append(" Average student.");
        } else {
            view.append(" Very nice person.");
        }
        System.out.println(view);
    }

    private boolean studentExists(String name) {
        return getRepository().containsKey(name);
    }

}
