package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class MergeTwoFiles {

    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader inputOneReader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
             BufferedReader inputTwoReader = new BufferedReader(new FileReader("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\output.txt", true))) {
            String currentInputOneLine = inputOneReader.readLine();
            while (currentInputOneLine != null) {
                writer.write(currentInputOneLine);
                writer.newLine();
                currentInputOneLine = inputOneReader.readLine();
            }
            String currentInputTwoLine = inputTwoReader.readLine();
            while (currentInputTwoLine != null) {
                writer.write(currentInputTwoLine);
                writer.newLine();
                currentInputTwoLine = inputTwoReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
