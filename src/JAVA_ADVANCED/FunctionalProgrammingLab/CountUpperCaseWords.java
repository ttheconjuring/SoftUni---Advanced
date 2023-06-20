package FunctionalProgrammingLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> wordsList = Arrays.stream(bufferedReader.readLine().split(" ")).collect(Collectors.toList());
            Predicate<String> startsWithCapitalLetter = word -> Character.isUpperCase(word.charAt(0));
            AtomicInteger counter = new AtomicInteger();
            List<String> wordsStartingWithCapitalLetterList = new ArrayList<>();
            wordsList.forEach(word -> {
                if(startsWithCapitalLetter.test(word)) {
                    counter.getAndIncrement();
                    wordsStartingWithCapitalLetterList.add(word);
                }
            });
            System.out.println(counter);
            wordsStartingWithCapitalLetterList.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
