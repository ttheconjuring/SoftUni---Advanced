package IteratorAndComparatorsExercise.StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            TreeSet<Person> personTreeSetUsingNameLengthComparator = new TreeSet<>(new NameLengthComparator());
            TreeSet<Person> personTreeSetUsingAgeComparator = new TreeSet<>(new AgeComparator());
            for (int i = 0; i < n; i++) {
                String[] inputArray = bufferedReader.readLine().split(" ");
                String name = inputArray[0];
                int age = Integer.parseInt(inputArray[1]);
                Person person = new Person(name, age);
                personTreeSetUsingNameLengthComparator.add(person);
                personTreeSetUsingAgeComparator.add(person);
            }
            personTreeSetUsingNameLengthComparator.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
            personTreeSetUsingAgeComparator.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
