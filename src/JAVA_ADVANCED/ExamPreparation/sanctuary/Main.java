package ExamPreparation.sanctuary;

public class Main {
    public static void main(String[] args) {
        Habitat park = new Habitat(10);
        Elephant e1 = new Elephant("Bobby", 10, "Thailand Zoo");
        System.out.println(e1);
        park.add(e1);
        System.out.println(park.remove("Bobby"));
        System.out.println(park.remove("Lola"));
        Elephant e2 = new Elephant("Bibi", 5, "Private Zoo");
        Elephant e3 = new Elephant("Lola", 7, "National Circus of Thailand");
        park.add(e2);
        park.add(e3);
        Elephant oldest = park.getOldestElephant();
        System.out.println(oldest);
        Elephant e = park.getElephant("Private Zoo");
        System.out.println(e);
        System.out.println(park.getAllElephants());
        System.out.println(park.getReport());
    }
}
