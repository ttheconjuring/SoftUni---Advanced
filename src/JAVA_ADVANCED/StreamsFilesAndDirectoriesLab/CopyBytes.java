package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        String readPath = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String writePath = "D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream readingStream = new FileInputStream(readPath);
        FileOutputStream writingSteam = new FileOutputStream(writePath);

        int oneByte = readingStream.read();
        String digits = String.valueOf(oneByte);

        while (oneByte >= 0) {
            if(oneByte == 32) {
                writingSteam.write(' ');
            } else if(oneByte == '\n') {
                writingSteam.write('\n');
            } else {
                for (int i = 0; i < digits.length(); i++) {
                    writingSteam.write(digits.charAt(i));
                }
            }
            oneByte = readingStream.read();
            digits = String.valueOf(oneByte);
        }

        readingStream.close();
        writingSteam.close();

    }

}
