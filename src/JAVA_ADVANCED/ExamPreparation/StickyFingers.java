package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StickyFingers {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[size][size];
            String[] commandsArray = bufferedReader.readLine().split(",");
            for (int i = 0; i < size; i++) {
                matrix[i] = bufferedReader.readLine().replace(" ", "").toCharArray();
            }
            int dillingerRow = -1;
            int dillingerColumn = -1;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j] == 'D') {
                        dillingerRow = i;
                        dillingerColumn = j;
                    }
                }
            }
            int pocket = 0;
            boolean gotCaught = false;
            for (int i = 0; i < commandsArray.length; i++) {
                switch (commandsArray[i]) {
                    case "up":
                        if (dillingerRow - 1 >= 0) {
                            if (matrix[dillingerRow - 1][dillingerColumn] == '$') {
                                matrix[dillingerRow - 1][dillingerColumn] = '+';
                                int stolenMoney = (dillingerRow - 1) * dillingerColumn;
                                pocket += stolenMoney;
                                System.out.println("You successfully stole " + stolenMoney + "$.");
                                matrix[dillingerRow--][dillingerColumn] = '+';
                            } else if (matrix[dillingerRow - 1][dillingerColumn] == 'P') {
                                gotCaught = true;
                                matrix[dillingerRow - 1][dillingerColumn] = '#';
                                matrix[dillingerRow--][dillingerColumn] = '+';
                            } else {
                                matrix[dillingerRow - 1][dillingerColumn] = 'D';
                                matrix[dillingerRow--][dillingerColumn] = '+';
                            }
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                    case "down":
                        if (dillingerRow + 1 < size) {
                            if (matrix[dillingerRow + 1][dillingerColumn] == '$') {
                                matrix[dillingerRow + 1][dillingerColumn] = '+';
                                int stolenMoney = (dillingerRow + 1) * dillingerColumn;
                                pocket += stolenMoney;
                                System.out.println("You successfully stole " + stolenMoney + "$.");
                                matrix[dillingerRow++][dillingerColumn] = '+';
                            } else if (matrix[dillingerRow + 1][dillingerColumn] == 'P') {
                                gotCaught = true;
                                matrix[dillingerRow + 1][dillingerColumn] = '#';
                                matrix[dillingerRow++][dillingerColumn] = '+';
                            } else {
                                matrix[dillingerRow + 1][dillingerColumn] = 'D';
                                matrix[dillingerRow++][dillingerColumn] = '+';
                            }
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                    case "left":
                        if (dillingerColumn - 1 >= 0) {
                            if (matrix[dillingerRow][dillingerColumn - 1] == '$') {
                                matrix[dillingerRow][dillingerColumn - 1] = '+';
                                int stolenMoney = dillingerRow * (dillingerColumn - 1);
                                pocket += stolenMoney;
                                System.out.println("You successfully stole " + stolenMoney + "$.");
                                matrix[dillingerRow][dillingerColumn--] = '+';
                            } else if (matrix[dillingerRow][dillingerColumn - 1] == 'P') {
                                gotCaught = true;
                                matrix[dillingerRow][dillingerColumn - 1] = '#';
                                matrix[dillingerRow][dillingerColumn--] = '+';
                            } else {
                                matrix[dillingerRow][dillingerColumn - 1] = 'D';
                                matrix[dillingerRow][dillingerColumn--] = '+';
                            }
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                    case "right":
                        if (dillingerColumn + 1 < size) {
                            if (matrix[dillingerRow][dillingerColumn + 1] == '$') {
                                matrix[dillingerRow][dillingerColumn + 1] = '+';
                                int stolenMoney = dillingerRow * (dillingerColumn + 1);
                                pocket += stolenMoney;
                                System.out.println("You successfully stole " + stolenMoney + "$.");
                                matrix[dillingerRow][dillingerColumn++] = '+';
                            } else if (matrix[dillingerRow][dillingerColumn + 1] == 'P') {
                                gotCaught = true;
                                matrix[dillingerRow][dillingerColumn + 1] = '#';
                                matrix[dillingerRow][dillingerColumn++] = '+';
                            } else {
                                matrix[dillingerRow][dillingerColumn + 1] = 'D';
                                matrix[dillingerRow][dillingerColumn++] = '+';
                            }
                        } else {
                            System.out.println("You cannot leave the town, there is police outside!");
                        }
                        break;
                }
                if (gotCaught) {
                    break;
                }
            }
            if (gotCaught) {
                System.out.println("You got caught with " + pocket + "$, and you are going to jail.");
            } else {
                System.out.println("Your last theft has finished successfully with " + pocket + "$ in your pocket.");
                matrix[dillingerRow][dillingerColumn] = 'D';
            }
            for (int i = 0; i < size; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < matrix[i].length; j++) {
                    sb.append(matrix[i][j]).append(" ");
                }
                System.out.println(sb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
