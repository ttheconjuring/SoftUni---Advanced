package StreamsFilesAndDirectoriesLab;

import java.io.File;

public class ListFiles {

    public static void main(String[] args) {
        File file = new File("D:\\ItelliJ IDEA Projects\\SoftUni - Advanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if(file.exists()) {
            if(file.isDirectory()) {
                File[] files = file.listFiles();
                assert files != null;
                for (File file1 : files) {
                    if(!file1.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file1.getName(), file1.length());
                    }
                }
            }
        }

    }

}
