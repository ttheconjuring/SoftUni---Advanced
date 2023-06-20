package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NavyBattle {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int submarineRow = -1;
            int submarineColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'S') {
                        submarineRow = i;
                        submarineColumn = j;
                    }
                }
            }
            int minesCounter = 0;
            boolean submarineDisappeared = false;
            int cruisersCounter = 0;
            boolean allCruisersAreDestroyed = false;
            do {
                String direction = bufferedReader.readLine();
                matrix[submarineRow][submarineColumn] = '-';
                switch (direction) {
                    case "up":
                        submarineRow--;
                        break;
                    case "down":
                        submarineRow++;
                        break;
                    case "left":
                        submarineColumn--;
                        break;
                    case "right":
                        submarineColumn++;
                        break;
                }
                if (matrix[submarineRow][submarineColumn] == '*') {
                    minesCounter++;
                } else if (matrix[submarineRow][submarineColumn] == 'C') {
                    cruisersCounter++;
                }
                matrix[submarineRow][submarineColumn] = '-';
                if (minesCounter == 3) {
                    submarineDisappeared = true;
                } else if (cruisersCounter == 3) {
                    allCruisersAreDestroyed = true;
                }
            } while (!submarineDisappeared && !allCruisersAreDestroyed);
            matrix[submarineRow][submarineColumn] = 'S';
            if (submarineDisappeared) {
                System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRow + ", " + submarineColumn + "]!");
            } else {
                System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
            }
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}