package SetsAndMapsAdvancedLab;

import java.util.*;

public class AverageStudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentNameGradeMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArray = scanner.nextLine().split("\\s+");
            String studentName = inputArray[0];
            studentNameGradeMap.putIfAbsent(studentName, new ArrayList<>());
            double studentGrade = Double.parseDouble(inputArray[1]);
            studentNameGradeMap.get(studentName).add(studentGrade);
        }

        for (Map.Entry<String, List<Double>> stringListEntry : studentNameGradeMap.entrySet()) {
            System.out.print(stringListEntry.getKey() + " -> ");
            double totalGradeSum = 0;
            for (Double aDouble : stringListEntry.getValue()) {
                System.out.print(String.format("%.2f", aDouble) + " ");
                totalGradeSum += aDouble;
            }
            System.out.print("(avg: " + String.format("%.2f", totalGradeSum / stringListEntry.getValue().size()) + ")");
            System.out.println();
        }

        scanner.close();
    }

}
