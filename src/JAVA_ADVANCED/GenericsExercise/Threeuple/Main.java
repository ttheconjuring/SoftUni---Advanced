package GenericsExercise.Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line1Array = bufferedReader.readLine().split(" ");
            String firstAndLastName = line1Array[0] + " " + line1Array[1];
            String address = line1Array[2];
            String town = line1Array[3];
            Threeuple<String, String, String> personsNameAddressTownTuple = new Threeuple<>(firstAndLastName, address, town);

            String[] line2Array = bufferedReader.readLine().split(" ");
            String name = line2Array[0];
            String litersOfBeer = line2Array[1];
            boolean drunkOrNot = false;
            if(line2Array[2].equals("drunk")) {
                drunkOrNot = true;
            }
            Threeuple<String, String, Boolean> nameLitersOfBeerDrunkOrNotTuple = new Threeuple<>(name, litersOfBeer, drunkOrNot);

            String[] line3Array = bufferedReader.readLine().split(" ");
            String user = line3Array[0];
            Double accountBalance = Double.parseDouble(line3Array[1]);
            String bankName= line3Array[2];
            Threeuple<String, Double, String> userAccountBalanceBankNameTuple = new Threeuple<>(user, accountBalance, bankName);

            System.out.println(personsNameAddressTownTuple.getItem1() + " -> " + personsNameAddressTownTuple.getItem2() + " -> " + personsNameAddressTownTuple.getItem3());
            System.out.println(nameLitersOfBeerDrunkOrNotTuple.getItem1() + " -> " + nameLitersOfBeerDrunkOrNotTuple.getItem2() + " -> " + nameLitersOfBeerDrunkOrNotTuple.getItem3());
            System.out.println(userAccountBalanceBankNameTuple.getItem1() + " -> " + userAccountBalanceBankNameTuple.getItem2() + " -> " + userAccountBalanceBankNameTuple.getItem3());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
