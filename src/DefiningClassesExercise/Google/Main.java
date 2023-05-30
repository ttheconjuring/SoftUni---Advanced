package DefiningClassesExercise.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Person> personList = new ArrayList<>();
            String input = bufferedReader.readLine();
            while (!input.equals("End")) {
                String[] inputArray = input.split(" ");
                String name = inputArray[0];
                boolean personExists = false;
                for (Person person : personList) {
                    if (person.getName().equals(name)) {
                        personExists = true;
                        break;
                    }
                }
                if (!personExists) {
                    Person person = new Person(name);
                    personList.add(person);
                }
                for (Person person : personList) {
                    if (person.getName().equals(name)) {
                        switch (inputArray[1]) {
                            case "company":
                                String companyName = inputArray[2];
                                String department = inputArray[3];
                                String salary = inputArray[4];
                                Person.Company company = new Person.Company(companyName, department, salary);
                                person.setCompany(company);
                                break;
                            case "pokemon":
                                String pokemonName = inputArray[2];
                                String pokemonType = inputArray[3];
                                Person.Pokemon pokemon = new Person.Pokemon(pokemonName, pokemonType);
                                person.getPokemonList().add(pokemon);
                                break;
                            case "parents":
                                String parentName = inputArray[2];
                                String parentBirthday = inputArray[3];
                                Person.Parents parents = new Person.Parents(parentName, parentBirthday);
                                person.getParentsList().add(parents);
                                break;
                            case "children":
                                String childName = inputArray[2];
                                String childBirthday = inputArray[3];
                                Person.Children children = new Person.Children(childName, childBirthday);
                                person.getChildrenList().add(children);
                                break;
                            case "car":
                                String carModel = inputArray[2];
                                String carSpeed = inputArray[3];
                                Person.Car car = new Person.Car(carModel, carSpeed);
                                person.setCar(car);
                                break;
                        }
                    }
                }
                input = bufferedReader.readLine();
            }
            String name = bufferedReader.readLine();
            for (Person person : personList) {
                if (person.getName().equals(name)) {
                    System.out.println(person.getName());
                    System.out.println("Company:");
                    if (person.getCompany() != null) {
                        System.out.println(person.getCompany().getName() + " " + person.getCompany().getDepartment() + " " + String.format("%.2f", Double.parseDouble(person.getCompany().getSalary())));
                    }
                    System.out.println("Car:");
                    if (person.getCar() != null) {
                        System.out.println(person.getCar().getModel() + " " + person.getCar().getSpeed());
                    }
                    System.out.println("Pokemon:");
                    if (!person.getPokemonList().isEmpty()) {
                        for (Person.Pokemon pokemon : person.getPokemonList()) {
                            System.out.println(pokemon.getName() + " " + pokemon.getType());
                        }
                    }
                    System.out.println("Parents:");
                    if (!person.getParentsList().isEmpty()) {
                        for (Person.Parents parents : person.getParentsList()) {
                            System.out.println(parents.getName() + " " + parents.getBirthday());
                        }
                    }
                    System.out.println("Children:");
                    if (!person.getChildrenList().isEmpty()) {
                        for (Person.Children children : person.getChildrenList()) {
                            System.out.println(children.getName() + " " + children.getBirthday());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
