package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class writeEveryThirdLine {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileInputStream("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
        PrintWriter writer = new PrintWriter(new FileOutputStream("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt"));

        int counter = 1;
        String line = reader.nextLine();
        while (reader.hasNextLine()) {
            if (counter == 3) {
                writer.println(line);
                counter = 1;
            } else {
                counter++;
            }
            line = reader.nextLine();
        }

        reader.close();
        writer.close();

    }

}
