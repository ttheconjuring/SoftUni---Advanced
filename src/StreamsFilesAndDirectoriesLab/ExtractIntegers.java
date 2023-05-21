package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) throws FileNotFoundException {
        String readPath = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner reader = new Scanner(new FileInputStream(readPath));
        PrintWriter writer = new PrintWriter(writePath);

        while (reader.hasNext()) {
            if(reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }
            reader.next();
        }

        reader.close();
        writer.close();

    }

}
