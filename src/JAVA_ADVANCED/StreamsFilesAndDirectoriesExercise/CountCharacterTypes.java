package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.List;

public class CountCharacterTypes {

    public static void main(String[] args) throws FileNotFoundException {

        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        List<Character> punctuation = List.of('!', ',', '.', '?');

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\output.txt"))) {
            int vowelsCounter = 0;
            int punctuationCounter = 0;
            int othersCounter = 0;
            String currentLine = reader.readLine();
            while (currentLine != null) {
                char[] characters = currentLine.toCharArray();
                for (char character : characters) {
                    if(vowels.contains(character)) {
                        vowelsCounter++;
                    } else if(punctuation.contains(character)) {
                        punctuationCounter++;
                    } else {
                        if(character != 32) {
                            othersCounter++;
                        }
                    }
                }
                currentLine = reader.readLine();
            }
            writer.write("Vowels: " + vowelsCounter);
            writer.newLine();
            writer.write("Other symbols: " + othersCounter);
            writer.newLine();
            writer.write("Punctuation: " + punctuationCounter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
