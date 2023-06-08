package IteratorAndComparatorsExercise.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String command = bufferedReader.readLine();
            ListyIterator<String> listyIterator = new ListyIterator<>();
            while (!command.equals("END")) {
                String[] commandArray = command.split(" ");
                switch (commandArray[0]) {
                    case "Create":
                        if (commandArray.length > 1) {
                            listyIterator = new ListyIterator<>(Arrays.copyOfRange(commandArray, 1, commandArray.length));
                        }
                        break;
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "Print":
                        try {
                            listyIterator.print();
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                }
                command = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
