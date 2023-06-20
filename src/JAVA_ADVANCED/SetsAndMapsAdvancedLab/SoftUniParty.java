package SetsAndMapsAdvancedLab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guest = scanner.nextLine();

        Set<String> regularGuestsSet = new TreeSet<>();
        Set<String> VIPGuestsSet = new TreeSet<>();

        while (!guest.equals("PARTY")) {
            if(Character.isDigit(guest.charAt(0))) {
                VIPGuestsSet.add(guest);
            } else {
                regularGuestsSet.add(guest);
            }
            guest = scanner.nextLine();
        }

        guest = scanner.nextLine();

        while (!guest.equals("END")) {
            if(VIPGuestsSet.contains(guest)) {
                VIPGuestsSet.remove(guest);
            } else {
                regularGuestsSet.remove(guest);
            }
            guest = scanner.nextLine();
        }

        System.out.println(regularGuestsSet.size() + VIPGuestsSet.size());
        for (String s : VIPGuestsSet) {
            System.out.println(s);
        }
        for (String s : regularGuestsSet) {
            System.out.println(s);
        }

        scanner.close();
    }

}
