package DefiningClassesExercise.OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            Person[] person = new Person[n];
            for (int i = 0; i < n; i++) {
                String[] inputArray = bufferedReader.readLine().split(" ");
                String name = inputArray[0];
                int age = Integer.parseInt(inputArray[1]);
                person[i] = new Person(name, age);
            }
            Arrays.stream(person).filter(person1 -> person1.getAge() > 30).sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
