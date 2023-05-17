package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shopProductPriceMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] inputArray = input.split(",\\s+");
            String shop = inputArray[0];
            shopProductPriceMap.putIfAbsent(shop, new LinkedHashMap<>());
            String product = inputArray[1];
            double price = Double.parseDouble(inputArray[2]);
            shopProductPriceMap.get(shop).putIfAbsent(product, price);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> stringMapEntry : shopProductPriceMap.entrySet()) {
            System.out.println(stringMapEntry.getKey() + "->");
            for (Map.Entry<String, Double> stringDoubleEntry : stringMapEntry.getValue().entrySet()) {
                System.out.println("Product: " + stringDoubleEntry.getKey() + ", Price: " + String.format("%.1f", stringDoubleEntry.getValue()));
            }
        }

        scanner.close();
    }

}
