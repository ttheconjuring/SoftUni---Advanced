package StreamsFilesAndDirectoriesLab;

import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {

    public static void main(String[] args) {

        File folder = new File("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.offer(folder);

        int counter = 0;

        while (!queue.isEmpty()) {
            File current = queue.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    queue.offer(nestedFile);
                }
            }
            counter++;
            System.out.println(current.getName());
        }

        System.out.println(counter + " folders");

    }

}
