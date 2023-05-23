package FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddVAT {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Double> pricesList = Arrays.stream(bufferedReader.readLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());
            Function<Double, Double> addVat = price -> price * 1.2;
            System.out.println("Prices with VAT: ");
            pricesList.forEach(price -> System.out.printf("%.2f%n", addVat.apply(price)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
