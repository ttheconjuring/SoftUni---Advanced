package MultidimensionalArraysExercise;

import java.util.*;

public class StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String settings = scanner.nextLine();
        int rotation = Integer.parseInt(settings.substring(7, settings.length() - 1));

        String input = scanner.nextLine();

        List<String> inputList = new ArrayList<>();
        int columns = 0;

        while (!input.equals("END")) {
            inputList.add(input);
            if (input.length() > columns) {
                columns = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = inputList.size();
        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            if (inputList.get(i).length() < columns) {
                StringBuilder completeElement = new StringBuilder(inputList.get(i));
                while (completeElement.length() != columns) {
                    completeElement.append(" ");
                }
                matrix[i] = completeElement.toString().toCharArray();
            } else {
                matrix[i] = inputList.get(i).toCharArray();
            }
        }

        char[][] rotatedMatrix;
        char[] currentMicroArray;

        switch (rotation % 360) {
            case 90:
                rotatedMatrix = new char[columns][rows];
                for (int i = 0; i < columns; i++) {
                    currentMicroArray = new char[rows];
                    for (int j = 0; j < rows; j++) {
                        currentMicroArray[j] = matrix[rows - 1 - j][i];
                    }
                    rotatedMatrix[i] = currentMicroArray;

                }
                print(rotatedMatrix);
                break;
            case 180:
                rotatedMatrix = new char[rows][columns];
                for (int i = 0; i < rows; i++) {
                    currentMicroArray = new char[columns];
                    for (int j = 0; j < columns; j++) {
                        currentMicroArray[j] = matrix[rows - 1 - i][columns - 1 - j];
                    }
                    rotatedMatrix[i] = currentMicroArray;
                }
                print(rotatedMatrix);
                break;
            case 270:
                rotatedMatrix = new char[columns][rows];
                for (int i = 0; i < columns; i++) {
                    currentMicroArray = new char[rows];
                    for (int j = 0; j < rows; j++) {
                        currentMicroArray[j] = matrix[j][columns - 1 - i];
                    }
                    rotatedMatrix[i] = currentMicroArray;
                }
                print(rotatedMatrix);
                break;
            default:
                print(matrix);
                break;
        }

        scanner.close();
    }

    private static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
