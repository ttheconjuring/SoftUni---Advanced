package GenericsExercise.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] line1Array = bufferedReader.readLine().split(" ");
            String firstAndLastName = line1Array[0] + " " + line1Array[1];
            String address = line1Array[2];
            Tuple<String, String> personsNameAndAddressTuple = new Tuple<>(firstAndLastName, address);

            String[] line2Array = bufferedReader.readLine().split(" ");
            String name = line2Array[0];
            String litersOfBeer = line2Array[1];
            Tuple<String, String> nameLitersOfBeer = new Tuple<>(name, litersOfBeer);

            String[] line3Array = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(line3Array[0]);
            double b = Double.parseDouble(line3Array[1]);
            Tuple<Integer, Double> abTuple = new Tuple<>(a, b);

            System.out.println(personsNameAndAddressTuple.getItem1() + " -> " + personsNameAndAddressTuple.getItem2());
            System.out.println(nameLitersOfBeer.getItem1() + " -> " + nameLitersOfBeer.getItem2());
            System.out.println(abTuple.getItem1() + " -> " + abTuple.getItem2());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
