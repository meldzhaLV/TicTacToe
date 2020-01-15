package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        char arr[] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        int x = 0;
        int y = 0;

        int i = 2;
        int moveCounter = 0;

        while(true) {
            printGameBoard(arr);
            System.out.print("Enter the coordinates: ");
            try {
                x = Integer.parseInt(reader.next());
                y = Integer.parseInt(reader.next());
                if(x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if(i % 2 == 0) {
                    if(!(xGoes(arr, x, y))) {
                        xGoes(arr, x, y);
                        i++;
                        moveCounter++;
                    } else {
                        continue;
                    }
                } else {
                    if(!(oGoes(arr, x, y))) {
                        oGoes(arr, x, y);
                        i++;
                        moveCounter++;
                    } else {
                        continue;
                    }
                }
                if(xWins(arr)) {
                    printGameBoard(arr);
                    System.out.println("X wins");
                    break;
                } else if (oWins(arr)) {
                    printGameBoard(arr);
                    System.out.println("O wins");
                    break;
                } else if (moveCounter == 9) {
                    printGameBoard(arr);
                    System.out.println("Draw");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
        }
    }

    public static void printGameBoard(char arr[]) {
        System.out.println("---------");
        System.out.println("| " + arr[0] + " " + arr[1] + " " + arr[2] + " |\n" +
                "| " + arr[3] + " " + arr[4] + " " + arr[5] + " |\n" +
                "| " + arr[6] + " " + arr[7] + " " + arr[8] + " |");
        System.out.println("---------");
    }

    public static boolean xGoes(char arr[], int x, int y) {
        boolean isOccupied = false;
        if(x == 1 && y == 3 && arr[0] == ' ') {
            arr[0] = 'X';
        } else if(x == 2 && y == 3 && arr[1] == ' ') {
            arr[1] = 'X';
        } else if(x == 3 && y == 3 && arr[2] == ' ') {
            arr[2] = 'X';
        } else if (x == 1 && y == 2 && arr[3] == ' ') {
            arr[3] = 'X';
        } else if (x == 2 && y == 2 && arr[4] == ' ') {
            arr[4] = 'X';
        } else if (x == 3 && y == 2 && arr[5] == ' ') {
            arr[5] = 'X';
        } else if (x == 1 && y == 1 && arr[6] == ' ') {
            arr[6] = 'X';
        } else if (x == 2 && y == 1 && arr[7] == ' ') {
            arr[7] = 'X';
        } else if (x == 3 && y == 1 && arr[8] == ' ') {
            arr[8] = 'X';
        } else {
            isOccupied = true;
            System.out.println("This cell is occupied! Choose another one!");
        }
        return isOccupied;
    }

    public static boolean oGoes(char arr[], int x, int y) {
        boolean isOccupied = false;
        if(x == 1 && y == 3 && arr[0] == ' ') {
            arr[0] = 'O';
        } else if(x == 2 && y == 3 && arr[1] == ' ') {
            arr[1] = 'O';
        } else if(x == 3 && y == 3 && arr[2] == ' ') {
            arr[2] = 'O';
        } else if (x == 1 && y == 2 && arr[3] == ' ') {
            arr[3] = 'O';
        } else if (x == 2 && y == 2 && arr[4] == ' ') {
            arr[4] = 'O';
        } else if (x == 3 && y == 2 && arr[5] == ' ') {
            arr[5] = 'O';
        } else if (x == 1 && y == 1 && arr[6] == ' ') {
            arr[6] = 'O';
        } else if (x == 2 && y == 1 && arr[7] == ' ') {
            arr[7] = 'O';
        } else if (x == 3 && y == 1 && arr[8] == ' ') {
            arr[8] = 'O';
        } else {
            isOccupied = true;
            System.out.println("This cell is occupied! Choose another one!");
        }
        return isOccupied;
    }

    public static boolean xWins(char arr[]) {
        // 'X' WINS
        boolean xWins = false;

        if(arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X') {
            xWins = true;
        }
        if(arr[3] == 'X' && arr[4] == 'X' && arr[5] == 'X') {
            xWins = true;
        }
        if(arr[6] == 'X' && arr[7] == 'X' && arr[8] == 'X') {
            xWins = true;
        }
        if(arr[0] == 'X' && arr[3] == 'X' && arr[6] == 'X') {
            xWins = true;
        }
        if(arr[1] == 'X' && arr[4] == 'X' && arr[7] == 'X') {
            xWins = true;
        }
        if(arr[2] == 'X' && arr[5] == 'X' && arr[8] == 'X') {
            xWins = true;
        }
        if(arr[0] == 'X' && arr[4] == 'X' && arr[8] == 'X') {
            xWins = true;
        }
        if(arr[2] == 'X' && arr[4] == 'X' && arr[6] == 'X') {
            xWins = true;
        }
        return xWins;
    }

    public static boolean oWins(char arr[]) {
        boolean oWins = false;

        if(arr[0] == 'O' && arr[1] == 'O' && arr[2] == 'O') {
            oWins = true;
        }
        if(arr[3] == 'O' && arr[4] == 'O' && arr[5] == 'O') {
            oWins = true;
        }
        if(arr[6] == 'O' && arr[7] == 'O' && arr[8] == 'O') {
            oWins = true;
        }
        if(arr[0] == 'O' && arr[3] == 'O' && arr[6] == 'O') {
            oWins = true;
        }
        if(arr[1] == 'O' && arr[4] == 'O' && arr[7] == 'O') {
            oWins = true;
        }
        if(arr[2] == 'O' && arr[5] == 'O' && arr[8] == 'O') {
            oWins = true;
        }
        if(arr[0] == 'O' && arr[4] == 'O' && arr[8] == 'O') {
            oWins = true;
        }
        if(arr[2] == 'O' && arr[4] == 'O' && arr[6] == 'O') {
            oWins = true;
        }
        return oWins;
    }

}
