package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RallyRacing {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][n];
            String racingNumber = bufferedReader.readLine();
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().replace(" ", "").toCharArray();
            }
            int carRow = 0;
            int carColumn = 0;
            int firstTunnelRow = -1;
            int firstTunnelColumn = -1;
            int secondTunnelRow = -1;
            int secondTunnelColumn = -1;
            int finishRow = -1;
            int finishColumn = -1;
            boolean theEndIsReached = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'T') {
                        if ((firstTunnelRow == -1) && (firstTunnelColumn == -1)) {
                            firstTunnelRow = i;
                            firstTunnelColumn = j;
                        } else if ((secondTunnelRow == -1) && (secondTunnelColumn == -1)) {
                            secondTunnelRow = i;
                            secondTunnelColumn = j;
                        }
                    } else if (matrix[i][j] == 'F') {
                        if (finishRow == -1) {
                            finishRow = i;
                            finishColumn= j;
                        }
                    }
                }
            }
            int kilometersPassed = 0;
            String direction = bufferedReader.readLine();
            while (!direction.equals("End")) {
                if (!theEndIsReached) {
                    switch (direction) {
                        case "left":
                            carColumn--;
                            break;
                        case "right":
                            carColumn++;
                            break;
                        case "up":
                            carRow--;
                            break;
                        case "down":
                            carRow++;
                            break;
                    }
                    switch (matrix[carRow][carColumn]) {
                        case 'T':
                            matrix[carRow][carColumn] = '.';
                            if ((carRow == firstTunnelRow) && (carColumn == firstTunnelColumn)) {
                                carRow = secondTunnelRow;
                                carColumn = secondTunnelColumn;
                            } else if ((carRow == secondTunnelRow) && (carColumn == secondTunnelColumn)) {
                                carRow = firstTunnelRow;
                                carColumn = firstTunnelColumn;
                            }
                            matrix[carRow][carColumn] = '.';
                            kilometersPassed += 30;
                            break;
                        case 'F':
                            theEndIsReached = true;
                            System.out.println("Racing car " + racingNumber + " finished the stage!");
                            kilometersPassed += 10;
                            break;
                        default:
                            kilometersPassed += 10;
                    }
                }
                direction = bufferedReader.readLine();
            }
            if (!theEndIsReached) {
                System.out.println("Racing car " + racingNumber + " DNF.");
            }
            System.out.println("Distance covered " + kilometersPassed + " km.");
            matrix[carRow][carColumn] = 'C';
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
