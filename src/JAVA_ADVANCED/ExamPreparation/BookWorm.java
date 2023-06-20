package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookWorm {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder initialString = new StringBuilder(bufferedReader.readLine());
            int size = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[size][size];
            for (int i = 0; i < size; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int currentRow = -1;
            int currentColumn = -1;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j] == 'P') {
                        currentRow = i;
                        currentColumn = j;
                    }
                }
            }
            String command = bufferedReader.readLine();
            while (!command.equals("end")) {
                switch (command) {
                    case "up":
                        if (currentRow - 1 >= 0) {
                            if (Character.isLetter(matrix[currentRow - 1][currentColumn])) {
                                initialString.append(matrix[currentRow - 1][currentColumn]);
                            }
                            matrix[currentRow][currentColumn] = '-';
                            currentRow = currentRow - 1;
                            matrix[currentRow][currentColumn] = 'P';
                        } else {
                            if (initialString.length() > 0) {
                                initialString.deleteCharAt(initialString.length() - 1);
                            }
                        }
                        break;
                    case "down":
                        if (currentRow + 1 < size) {
                            if (Character.isLetter(matrix[currentRow + 1][currentColumn])) {
                                initialString.append(matrix[currentRow + 1][currentColumn]);
                            }
                            matrix[currentRow][currentColumn] = '-';
                            currentRow = currentRow + 1;
                            matrix[currentRow][currentColumn] = 'P';
                        } else {
                            if (initialString.length() > 0) {
                                initialString.deleteCharAt(initialString.length() - 1);
                            }
                        }
                        break;
                    case "left":
                        if (currentColumn - 1 >= 0) {
                            if (Character.isLetter(matrix[currentRow][currentColumn - 1])) {
                                initialString.append(matrix[currentRow][currentColumn - 1]);
                            }
                            matrix[currentRow][currentColumn] = '-';
                            currentColumn = currentColumn - 1;
                            matrix[currentRow][currentColumn] = 'P';
                        } else {
                            if (initialString.length() > 0) {
                                initialString.deleteCharAt(initialString.length() - 1);
                            }
                        }
                        break;
                    case "right":
                        if (currentColumn + 1 < size) {
                            if (Character.isLetter(matrix[currentRow][currentColumn + 1])) {
                                initialString.append(matrix[currentRow][currentColumn + 1]);
                            }
                            matrix[currentRow][currentColumn] = '-';
                            currentColumn = currentColumn + 1;
                            matrix[currentRow][currentColumn] = 'P';
                        } else {
                            if (initialString.length() > 0) {
                                initialString.deleteCharAt(initialString.length() - 1);
                            }
                        }
                        break;
                }
                command = bufferedReader.readLine();
            }
            System.out.println(initialString);
            for (int i = 0; i < size; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
