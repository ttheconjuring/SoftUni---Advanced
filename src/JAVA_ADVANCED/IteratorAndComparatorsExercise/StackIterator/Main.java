package IteratorAndComparatorsExercise.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            CustomStack<Integer> customStack = new CustomStack<>();
            String command = bufferedReader.readLine();
            while (!command.equals("END")) {
                String[] commandArray = command.split(" ");
                switch (commandArray[0]) {
                    case "Push":
                        String[] array = Arrays.copyOfRange(commandArray, 1, commandArray.length);
                        for (int i = 0; i < array.length; i++) {
                            customStack.push(Integer.parseInt(array[i].substring(0, 1)));
                        }
                        break;
                    case "Pop":
                        try {
                            customStack.pop();
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
                command = bufferedReader.readLine();
            }
            for (int i = 0; i < 2; i++) {
                Iterator<Integer> integerIterator = customStack.iterator();
                while (integerIterator.hasNext()) {
                    System.out.println(integerIterator.next());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
