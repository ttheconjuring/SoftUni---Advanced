package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThroneConquering {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int energy = Integer.parseInt(bufferedReader.readLine());
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int parisRow = -1;
            int parisColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 'P') {
                        parisRow = i;
                        parisColumn = j;
                    }
                }
            }
            boolean parisIsDead = false;
            boolean parisFoundHelen = false;
            while (energy > 0) {
                String[] commandArray = bufferedReader.readLine().split(" ");
                int spawnRow = Integer.parseInt(commandArray[1]);
                int spawnColumn = Integer.parseInt(commandArray[2]);
                matrix[spawnRow][spawnColumn] = 'S';
                switch (commandArray[0]) {
                    case "up":
                        energy--;
                        if (parisRow - 1 >= 0) {
                            if (matrix[parisRow - 1][parisColumn] == 'H') {
                                parisFoundHelen = true;
                                matrix[parisRow - 1][parisColumn] = '-';
                            } else if (matrix[parisRow - 1][parisColumn] == 'S') {
                                energy -= 2;
                                if (energy <= 0) {
                                    parisIsDead = true;
                                } else {
                                    matrix[parisRow - 1][parisColumn] = 'P';
                                }
                            } else {
                                matrix[parisRow - 1][parisColumn] = 'P';
                            }
                            matrix[parisRow][parisColumn] = '-';
                            parisRow--;
                        }
                        break;
                    case "down":
                        energy--;
                        if (parisRow + 1 < n) {
                            if (matrix[parisRow + 1][parisColumn] == 'H') {
                                parisFoundHelen = true;
                                matrix[parisRow + 1][parisColumn] = '-';
                            } else if (matrix[parisRow + 1][parisColumn] == 'S') {
                                energy -= 2;
                                if (energy <= 0) {
                                    parisIsDead = true;
                                } else {
                                    matrix[parisRow + 1][parisColumn] = 'P';
                                }
                            } else {
                                matrix[parisRow + 1][parisColumn] = 'P';
                            }
                            matrix[parisRow][parisColumn] = '-';
                            parisRow++;
                        }
                        break;
                    case "left":
                        energy--;
                        if (parisColumn - 1 >= 0) {
                            if (matrix[parisRow][parisColumn - 1] == 'H') {
                                parisFoundHelen = true;
                                matrix[parisRow][parisColumn - 1] = '-';
                            } else if (matrix[parisRow][parisColumn - 1] == 'S') {
                                energy -= 2;
                                if (energy <= 0) {
                                    parisIsDead = true;
                                } else {
                                    matrix[parisRow][parisColumn - 1] = 'P';
                                }
                            } else {
                                matrix[parisRow][parisColumn - 1] = 'P';
                            }
                            matrix[parisRow][parisColumn] = '-';
                            parisColumn--;
                        }
                        break;
                    case "right":
                        energy--;
                        if (parisColumn + 1 < matrix[parisRow].length) {
                            if (matrix[parisRow][parisColumn + 1] == 'H') {
                                parisFoundHelen = true;
                                matrix[parisRow][parisColumn + 1] = '-';
                            } else if (matrix[parisRow][parisColumn + 1] == 'S') {
                                energy -= 2;
                                if (energy <= 0) {
                                    parisIsDead = true;
                                } else {
                                    matrix[parisRow][parisColumn + 1] = 'P';
                                }
                            } else {
                                matrix[parisRow][parisColumn + 1] = 'P';
                            }
                            matrix[parisRow][parisColumn] = '-';
                            parisColumn++;
                        }
                        break;
                }
                if (parisIsDead || parisFoundHelen) {
                    break;
                }
            }
            if (parisFoundHelen) {
                System.out.println("Paris has successfully abducted Helen! Energy left: " + energy);
            } else {
                matrix[parisRow][parisColumn] = 'X';
                System.out.println("Paris died at " + parisRow + ";" + parisColumn + ".");
            }
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

}
