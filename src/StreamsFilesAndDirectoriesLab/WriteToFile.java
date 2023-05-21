package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {

    public static void main(String[] args) throws IOException {
        String readPath = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream readingStream = new FileInputStream(readPath);
        FileOutputStream writingStream = new FileOutputStream(writePath);

        int oneByte = readingStream.read();

        while(oneByte >= 0) {
            char symbol = (char)oneByte;
            if(symbol != ',' && symbol != '.' && symbol != '!' && symbol != '?') {
                writingStream.write(symbol);
            }
            oneByte = readingStream.read();
        }

        readingStream.close();
        writingStream.close();

    }

}
