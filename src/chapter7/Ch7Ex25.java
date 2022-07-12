package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: solve quadratic equations
 */
public class Ch7Ex25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter  b and c :");
        double[] eqn = new double[3];
        for (int i = 0; i < eqn.length; i++) {
            eqn[i] = scanner.nextDouble();
        }
        double[] roots = new double[2];
        int rootNumber = solveQuadratic(eqn, roots);
        System.out.print("the number of real roots are" + rootNumber);
        if (rootNumber == 1) {
            System.out.println("the real root is " + roots[0]);
        } else if (rootNumber == 2) {
            System.out.println("the real roots are " + roots[0] + " and " + roots[1]);
        }
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {
        double a = eqn[0];
        double b = eqn[1];
        double c = eqn[2];
        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant < 0) {
            return 0;
        } else if (discriminant == 0) {
            roots[0] = -b / (2 * a);
            return 1;
        } else {
            roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
            roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
            return 2;
        }
    }
}
