package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class ALLCAPITALS {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\output.txt")
        )){
            String currentLine = reader.readLine();
            while (currentLine != null) {
                writer.write(currentLine.toUpperCase());
                writer.newLine();
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
