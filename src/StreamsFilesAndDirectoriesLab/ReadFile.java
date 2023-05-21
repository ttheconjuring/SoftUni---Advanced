package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        String path = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream readingStream = new FileInputStream(path);

        int oneByte = readingStream.read();

        while (oneByte >= 0) {
            System.out.print(oneByte + " ");
            oneByte = readingStream.read();
        }

        readingStream.close();

    }

}
