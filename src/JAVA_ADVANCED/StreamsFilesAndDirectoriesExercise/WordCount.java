package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.*;

public class WordCount {

    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader wordsReader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
             BufferedReader textReader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\output.txt"))) {
            Map<String, Integer> wordsOccurencesMap = new HashMap<>();
            for (String word : wordsReader.readLine().split(" ")) {
                wordsOccurencesMap.putIfAbsent(word, 0);
            }
            String currentLine = textReader.readLine();
            String[] wordsArray = currentLine.split("\\s+");
            for (String word : wordsArray) {
                if(wordsOccurencesMap.containsKey(word)) {
                    wordsOccurencesMap.put(word, wordsOccurencesMap.get(word) + 1);
                }
            }
            Map<String, Integer> sortedMap = sortByValueDescending(wordsOccurencesMap);
            for (Map.Entry<String, Integer> stringIntegerEntry : sortedMap.entrySet()) {
                writer.write(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Map<String, Integer> sortByValueDescending(Map<String, Integer> map) {
        // Convert the map into a list of entries
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        // Sort the list using a custom Comparator
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        // Create a new LinkedHashMap to maintain the sorted order
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        // Put the entries into the sorted map
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
