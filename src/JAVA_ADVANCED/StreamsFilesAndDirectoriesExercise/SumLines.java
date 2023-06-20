package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"))){
            String currentLine = reader.readLine();
            while (currentLine != null) {
                int sum = 0;
                char[] characters = currentLine.toCharArray();
                for (char character : characters) {
                    sum += character;
                }
                System.out.println(sum);
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
