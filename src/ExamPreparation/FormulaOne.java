package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormulaOne {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());
            char[][] matrix = new char[n][n];
            int m = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                matrix[i] = bufferedReader.readLine().toCharArray();
            }
            int playerRow = -1;
            int playerColumn = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'P') {
                        playerRow = i;
                        playerColumn = j;
                    }
                }
            }
            boolean finishReached = false;
            for (int i = 0; i < m; i++) {
                String command = bufferedReader.readLine();
                switch (command) {
                    case "up":
                        if (playerRow - 1 >= 0) {
                            if (matrix[playerRow - 1][playerColumn] == 'F') {
                                matrix[playerRow - 1][playerColumn] = 'P';
                                matrix[playerRow--][playerColumn] = '.';
                                finishReached = true;
                            } else if (matrix[playerRow - 1][playerColumn] == 'B') {
                                matrix[playerRow--][playerColumn] = '.';
                                if (playerRow - 1 >= 0) {
                                    if (matrix[playerRow - 1][playerColumn] == 'F') {
                                        matrix[playerRow - 1][playerColumn] = 'P';
                                        playerRow--;
                                        finishReached = true;
                                    } else {
                                        matrix[playerRow - 1][playerColumn] = 'P';
                                        playerRow--;
                                    }
                                } else {
                                    if (matrix[n - 1][playerColumn] != 'T') {
                                        playerRow = n - 1;
                                        if (matrix[playerRow][playerColumn] == 'F') {
                                            matrix[playerRow][playerColumn] = 'P';
                                            finishReached = true;
                                        } else if (matrix[playerRow][playerColumn] == 'B') {
                                            matrix[--playerRow][playerColumn] = 'P';
                                        } else {
                                            matrix[playerRow][playerColumn] = 'P';
                                        }
                                    } else {
                                        playerRow = 1;
                                        matrix[playerRow][playerColumn] = 'P';
                                    }
                                }
                            } else if (matrix[playerRow - 1][playerColumn] == '.') {
                                matrix[playerRow - 1][playerColumn] = 'P';
                                matrix[playerRow--][playerColumn] = '.';
                            }
                        } else {
                            if (matrix[n - 1][playerColumn] != 'T') {
                                matrix[playerRow][playerColumn] = '.';
                                playerRow = n - 1;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'P';
                                    finishReached = true;
                                } else if (matrix[playerRow][playerColumn] == 'B') {
                                    matrix[--playerRow][playerColumn] = 'P';
                                } else {
                                    matrix[playerRow][playerColumn] = 'P';
                                }
                            }
                        }
                        break;
                    case "down":
                        if (playerRow + 1 < n) {
                            if (matrix[playerRow + 1][playerColumn] == 'F') {
                                matrix[playerRow + 1][playerColumn] = 'P';
                                matrix[playerRow++][playerColumn] = '.';
                                finishReached = true;
                            } else if (matrix[playerRow + 1][playerColumn] == 'B') {
                                matrix[playerRow++][playerColumn] = '.';
                                if (playerRow + 1 < n) {
                                    if (matrix[playerRow + 1][playerColumn] == 'F') {
                                        matrix[playerRow + 1][playerColumn] = 'P';
                                        playerRow++;
                                        finishReached = true;
                                    } else {
                                        matrix[playerRow + 1][playerColumn] = 'P';
                                        playerRow++;
                                    }
                                } else {
                                    if (matrix[0][playerColumn] != 'T') {
                                        playerRow = 0;
                                        if (matrix[playerRow][playerColumn] == 'F') {
                                            matrix[playerRow][playerColumn] = 'P';
                                            finishReached = true;
                                        } else if (matrix[playerRow][playerColumn] == 'B') {
                                            matrix[++playerRow][playerColumn] = 'P';
                                        } else {
                                            matrix[playerRow][playerColumn] = 'P';
                                        }
                                    } else {
                                        playerRow = n - 2;
                                        matrix[playerRow][playerColumn] = 'P';
                                    }
                                }
                            } else if (matrix[playerRow + 1][playerColumn] == '.') {
                                matrix[playerRow + 1][playerColumn] = 'P';
                                matrix[playerRow++][playerColumn] = '.';
                            }
                        } else {
                            if (matrix[0][playerColumn] != 'T') {
                                matrix[playerRow][playerColumn] = '.';
                                playerRow = 0;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'P';
                                    finishReached = true;
                                } else if (matrix[playerRow][playerColumn] == 'B') {
                                    matrix[++playerRow][playerColumn] = 'P';
                                } else {
                                    matrix[playerRow][playerColumn] = 'P';
                                }
                            }
                        }
                        break;
                    case "left":
                        if (playerColumn - 1 >= 0) {
                            if (matrix[playerRow][playerColumn - 1] == 'F') {
                                matrix[playerRow][playerColumn - 1] = 'P';
                                matrix[playerRow][playerColumn--] = '.';
                                finishReached = true;
                            } else if (matrix[playerRow][playerColumn - 1] == 'B') {
                                matrix[playerRow][playerColumn--] = '.';
                                if (playerColumn - 1 >= 0) {
                                    if (matrix[playerRow][playerColumn - 1] == 'F') {
                                        matrix[playerRow][playerColumn - 1] = 'P';
                                        playerColumn--;
                                        finishReached = true;
                                    } else {
                                        matrix[playerRow][playerColumn - 1] = 'P';
                                        playerColumn--;
                                    }
                                } else {
                                    if (matrix[playerRow][n - 1] != 'T') {
                                        playerColumn = n - 1;
                                        if (matrix[playerRow][playerColumn] == 'F') {
                                            matrix[playerRow][playerColumn] = 'P';
                                            finishReached = true;
                                        } else if (matrix[playerRow][playerColumn] == 'B') {
                                            matrix[playerRow][--playerColumn] = 'P';
                                        } else {
                                            matrix[playerRow][playerColumn] = 'P';
                                        }
                                    } else {
                                        playerColumn = 1;
                                        matrix[playerRow][playerColumn] = 'P';
                                    }
                                }
                            } else if (matrix[playerRow][playerColumn - 1] == '.') {
                                matrix[playerRow][playerColumn - 1] = 'P';
                                matrix[playerRow][playerColumn--] = '.';
                            }
                        } else {
                            if (matrix[playerRow][n - 1] != 'T') {
                                matrix[playerRow][playerColumn] = '.';
                                playerColumn = n - 1;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'P';
                                    finishReached = true;
                                } else if (matrix[playerRow][playerColumn] == 'B') {
                                    matrix[playerRow][--playerColumn] = 'P';
                                } else {
                                    matrix[playerRow][playerColumn] = 'P';
                                }
                            }
                        }
                        break;
                    case "right":
                        if (playerColumn + 1 < n) {
                            if (matrix[playerRow][playerColumn + 1] == 'F') {
                                matrix[playerRow][playerColumn + 1] = 'P';
                                matrix[playerRow][playerColumn++] = '.';
                                finishReached = true;
                            } else if (matrix[playerRow][playerColumn + 1] == 'B') {
                                matrix[playerRow][playerColumn++] = '.';
                                if (playerColumn + 1 < n) {
                                    if (matrix[playerRow][playerColumn + 1] == 'F') {
                                        matrix[playerRow][playerColumn + 1] = 'P';
                                        playerColumn++;
                                        finishReached = true;
                                    } else {
                                        matrix[playerRow][playerColumn + 1] = 'P';
                                        playerColumn++;
                                    }
                                } else {
                                    if (matrix[playerRow][0] != 'T') {
                                        playerColumn = 0;
                                        if (matrix[playerRow][playerColumn] == 'F') {
                                            matrix[playerRow][playerColumn] = 'P';
                                            finishReached = true;
                                        } else if (matrix[playerRow][playerColumn] == 'B') {
                                            matrix[playerRow][++playerColumn] = 'P';
                                        } else {
                                            matrix[playerRow][playerColumn] = 'P';
                                        }
                                    } else {
                                        playerColumn = n - 2;
                                        matrix[playerRow][playerColumn] = 'P';
                                    }
                                }
                            } else if (matrix[playerRow][playerColumn + 1] == '.') {
                                matrix[playerRow][playerColumn + 1] = 'P';
                                matrix[playerRow][playerColumn++] = '.';
                            }
                        } else {
                            if (matrix[playerRow][0] != 'T') {
                                matrix[playerRow][playerColumn] = '.';
                                playerColumn = 0;
                                if (matrix[playerRow][playerColumn] == 'F') {
                                    matrix[playerRow][playerColumn] = 'P';
                                    finishReached = true;
                                } else if (matrix[playerRow][playerColumn] == 'B') {
                                    matrix[playerRow][++playerColumn] = 'P';
                                } else {
                                    matrix[playerRow][playerColumn] = 'P';
                                }
                            }
                        }
                        break;
                }
                if (finishReached) {
                    break;
                }
            }
            if (finishReached) {
                System.out.println("Well done, the player won first place!");
            } else {
                System.out.println("Oh no, the player got lost on the track!");
            }
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

