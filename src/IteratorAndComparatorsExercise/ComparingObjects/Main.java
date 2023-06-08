package IteratorAndComparatorsExercise.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Person> personList = new ArrayList<>();
            String command = bufferedReader.readLine();
            while (!command.equals("END")) {
                String[] commandArray = command.split(" ");
                String name = commandArray[0];
                int age = Integer.parseInt(commandArray[1]);
                String town = commandArray[2];
                Person person = new Person(name, age, town);
                personList.add(person);
                command = bufferedReader.readLine();
            }
            int numberOfEqualPeople = 0;
            int numberOfNotEqualPeople = 0;
            int totalNumberOfPeople = personList.size();
            Person specificPerson = personList.get(Integer.parseInt(bufferedReader.readLine()) - 1);
            personList.remove(specificPerson);
            for (Person person : personList) {
                if(person.compareTo(specificPerson) == 0) {
                    numberOfEqualPeople++;
                } else {
                    numberOfNotEqualPeople++;
                }
            }
            if(numberOfEqualPeople == 0) {
                System.out.println("No matches");
            } else {
                System.out.println(numberOfEqualPeople + 1 + " " + numberOfNotEqualPeople + " " + totalNumberOfPeople);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
