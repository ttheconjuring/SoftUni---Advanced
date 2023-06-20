package ExamPreparation.shelter;

public class Main {
    public static void main(String[] args) {

        Shelter shelter = new Shelter(15);

        Animal animal = new Animal("Rex", 7, "Sara");

        System.out.println(animal);

        shelter.add(animal);

        System.out.println(shelter.remove("Rex"));
        System.out.println(shelter.remove("Cayra"));

        Animal animal1 = new Animal("Bela", 3, "Sia");
        Animal animal2 = new Animal("Stormy", 4, "George");

        shelter.add(animal1);
        shelter.add(animal2);

        Animal oldestAnimal = shelter.getOldestAnimal();
        System.out.println(oldestAnimal);

        Animal animal3 = shelter.getAnimal("Bela", "Sia");
        System.out.println(animal3);

        System.out.println(shelter.getCount());

        System.out.println(shelter.getStatistics());

    }
}