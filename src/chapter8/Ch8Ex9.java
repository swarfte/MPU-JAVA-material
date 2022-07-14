package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game : play a tic-tac-toe game
 */
public class Ch8Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] table = new int[3][3];
        char[] symbol = {'X', 'O'};
        int player = 1;

        while (true) {
            showTable(table);
            if (isDraw(table)) {
                System.out.println("Draw!");
                break;
            }

            player = nextPlayer(player);
            System.out.print("Enter a row(0, 1, or 2) for player " + symbol[player] + " : ");
            int row = scanner.nextInt();
            System.out.print("Enter a column(0, 1, or 2) for player " + symbol[player] + " : ");
            int column = scanner.nextInt();
            setTableValue(table, row, column, player);

            if (isWin(table, row, column, symbol[player])) {
                showTable(table);
                System.out.println(symbol[player] + " player won");
                break;
            }
        }
    }

    public static void setTableValue(int[][] table, int row, int column, int player) {
        if (player == 0) {
            table[row][column] = -1;
        } else {
            table[row][column] = 1;
        }
    }

    public static int nextPlayer(int player) {
        return player == 1 ? 0 : 1;
    }

    public static boolean isDraw(int[][] table) {
        int count = 0;
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                if (table[row][column] != 0) {
                    count++;
                }
            }
        }
        return count == (int) (Math.pow(table.length, 2));
    }

    public static boolean isWin(int[][] table, int row, int column, char symbol) {
        int number = symbol == 'X' ? -1 : 1;
        int rowCount = 0;
        int columnCount = 0;
        int mainDiagonalCount = 0;
        int secondaryDiagonalCount = 0;

        for (int i = 0; i < table.length; i++) {
            // check the row
            if (table[row][i] == number) {
                rowCount++;
            }

            // check the column
            if (table[i][column] == number) {
                columnCount++;
            }

            // check the main diagonal
            if (table[i][i] == number) {
                mainDiagonalCount++;
            }

            // check the secondary diagonal
            if (table[i][table.length - 1 - i] == number) {
                secondaryDiagonalCount++;
            }
        }
        return rowCount == 3 || columnCount == 3 || mainDiagonalCount == 3 || secondaryDiagonalCount == 3;
    }

    public static char[][] numberToSymbol(int[][] table) {
        char[][] displayTable = new char[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 1) {
                    displayTable[i][j] = 'O';
                } else if (table[i][j] == -1) {
                    displayTable[i][j] = 'X';
                } else {
                    displayTable[i][j] = ' ';
                }
            }
        }
        return displayTable;
    }

    public static void showTable(int[][] table) {
        int lineSize = 15;
        String line = "-".repeat(lineSize);
        char[][] displayTable = numberToSymbol(table);
        for (int i = 0; i < table.length; i++) {
            System.out.println(line);
            System.out.printf("| %c | %c | %c |\n", displayTable[i][0], displayTable[i][1], displayTable[i][2]);
        }
        System.out.println(line);
    }
}
