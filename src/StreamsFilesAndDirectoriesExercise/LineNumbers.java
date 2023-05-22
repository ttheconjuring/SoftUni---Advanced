package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class LineNumbers {

    public static void main(String[] args) throws FileNotFoundException {

        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\output.txt"))) {
            String currentLine = reader.readLine();
            int counter = 1;
            while (currentLine != null) {
                writer.write(counter++ + ". " + currentLine);
                writer.newLine();
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
