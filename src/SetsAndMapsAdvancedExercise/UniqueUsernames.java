package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> usernamesSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            usernamesSet.add(scanner.nextLine());
        }

        for (String s : usernamesSet) {
            System.out.println(s);
        }

        scanner.close();
    }

}
