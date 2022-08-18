package chapter18.ex24;

/**
 * @author swarfte
 */
public class Ch18Ex24 {


    static boolean isSafe(int xPoint, int yPoint, int[][] solutions, int numbers) {
        return (xPoint >= 0 && xPoint < numbers && yPoint >= 0 && yPoint < numbers && solutions[xPoint][yPoint] == -1);
    }

    static void printSolution(int[][] solutions, int numbers) {
        for (int x = 0; x < numbers; x++) {
            for (int y = 0; y < numbers; y++) {
                System.out.print(solutions[x][y] + " ");
            }
            System.out.println();
        }
    }

    static void solveKT(int numbers) {
        int[][] solutions = new int[8][8];

        for (int x = 0; x < numbers; x++) {
            for (int y = 0; y < numbers; y++) {
                solutions[x][y] = -1;
            }
        }
        int[] xPointMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yPointMove = {1, 2, 2, 1, -1, -2, -2, -1};

        solutions[0][0] = 0;

        if (!solveKtUtil(0, 0, 1, solutions, xPointMove, yPointMove, numbers)) {
            System.out.println("Solution does not exist");
        } else {
            printSolution(solutions, numbers);
        }

    }

    static boolean solveKtUtil(int xPoint, int yPoint, int moveI, int[][] solutions, int[] xMove, int[] yMove, int numbers) {
        int walk;
        int nextX;
        int nextY;
        if (moveI == numbers * numbers) {
            return true;
        }

        int walkSize = 8;
        for (walk = 0; walk < walkSize; walk++) {
            nextX = xPoint + xMove[walk];
            nextY = yPoint + yMove[walk];
            if (isSafe(nextX, nextY, solutions, numbers)) {
                solutions[nextX][nextY] = moveI;
                if (solveKtUtil(nextX, nextY, moveI + 1, solutions, xMove, yMove, numbers)) {
                    return true;
                } else {
                    solutions[nextX][nextY] = -1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int number = 8;
        solveKT(number);
    }
}
