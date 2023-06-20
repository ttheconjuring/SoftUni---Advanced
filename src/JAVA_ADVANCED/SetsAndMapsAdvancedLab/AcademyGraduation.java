package SetsAndMapsAdvancedLab;

import java.util.*;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentNameAverageScoreMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double[] scoresArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            int m = scoresArray.length;
            double totalScore = 0;
            for (int j = 0; j < m; j++) {
                totalScore += scoresArray[j];
            }
            double averageScore = totalScore / m;
            studentNameAverageScoreMap.putIfAbsent(studentName, averageScore);
        }

        for (Map.Entry<String, Double> stringDoubleEntry : studentNameAverageScoreMap.entrySet()) {
            System.out.println(stringDoubleEntry.getKey() + " is graduated with " + stringDoubleEntry.getValue());
        }

        scanner.close();
    }

}
