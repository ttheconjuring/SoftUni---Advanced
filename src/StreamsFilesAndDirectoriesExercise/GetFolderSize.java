package StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.io.IOException;

public class GetFolderSize {

    public static void main(String[] args) throws IOException {

        File folder = new File("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");
        System.out.println("Folder size: " + folder.length());

    }

}
