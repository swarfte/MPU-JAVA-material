package chapter8;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: solve linear equations
 */
public class Ch8Ex30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a00, a01, a10, a11, b0 and b1 :");
        double[][] a = new double[2][2];
        double[] b = new double[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextDouble();
            }
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextDouble();
        }

        double[] answer = linearEquation(a, b);
        if (answer != null) {
            System.out.println("x = " + answer[0] + " y = " + answer[1]);
        }
    }

    public static double[] linearEquation(double[][] a, double[] b) {
        double[] answer = new double[2];
        if (a[0][0] * a[1][1] - a[0][1] * a[1][0] == 0) {
            System.out.println("The equation has no solution.");
            return null;
        }
        answer[0] = (b[0] * a[1][1] - b[1] * a[0][1]) / (a[0][0] * a[1][1] - a[0][1] * a[1][0]);
        answer[1] = (b[1] * a[0][0] - b[0] * a[1][0]) / (a[0][0] * a[1][1] - a[0][1] * a[1][0]);
        return answer;
    }
}
