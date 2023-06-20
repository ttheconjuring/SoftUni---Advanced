package DefiningClassesExercise.CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Map<String, List<Employee>> departmentEmployeesMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String[] employeeInformationArray = bufferedReader.readLine().split(" ");
                String name = employeeInformationArray[0];
                double salary = Double.parseDouble(employeeInformationArray[1]);
                String position = employeeInformationArray[2];
                String department = employeeInformationArray[3];
                departmentEmployeesMap.putIfAbsent(department, new ArrayList<>());
                Employee employee = null;
                switch (employeeInformationArray.length) {
                    case 5:
                        if (employeeInformationArray[4].contains("@")) {
                            String email = employeeInformationArray[4];
                            employee = new Employee(name, salary, position, department, email);
                        } else {
                            int age = Integer.parseInt(employeeInformationArray[4]);
                            employee = new Employee(name, salary, position, department, age);
                        }
                        break;
                    case 6:
                        String email = employeeInformationArray[4];
                        int age = Integer.parseInt(employeeInformationArray[5]);
                        employee = new Employee(name, salary, position, department, email, age);
                        break;
                    default:
                        employee = new Employee(name, salary, position, department);
                }
                departmentEmployeesMap.get(department).add(employee);
            }
            Map<String, Double> departmentAverageSalary = new HashMap<>();
            for (Map.Entry<String, List<Employee>> stringListEntry : departmentEmployeesMap.entrySet()) {
                double total = 0;
                for (Employee employee : stringListEntry.getValue()) {
                    total += employee.getSalary();
                }
                double averageDepartmentSalary = total / stringListEntry.getValue().size();
                departmentAverageSalary.put(stringListEntry.getKey(), averageDepartmentSalary);
            }
            Map<String, Double> sortedMap = departmentAverageSalary.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            String highestPaidDepartment = "";
            for (Map.Entry<String, Double> stringDoubleEntry : sortedMap.entrySet()) {
                highestPaidDepartment = stringDoubleEntry.getKey();
            }
            List<Employee> employeeList = departmentEmployeesMap.get(highestPaidDepartment);
            employeeList.sort(Comparator.comparing(Employee::getSalary));
            Collections.reverse(employeeList);
            System.out.println("Highest Average Salary: " + highestPaidDepartment);
            employeeList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
