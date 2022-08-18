package chapter18.ex3;

import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ch18Ex3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();
        System.out.print("Enter the base: ");
        int base = scanner.nextInt();
        System.out.print("Enter the exponent: ");
        int exponent = scanner.nextInt();
        dec2b(number, base, exponent);
    }

    public static void dec2b(double x, int b, int n) {
        if (0 <= x && x < 1) {
            dec2b(x, b, n, new StringBuilder());
        }

    }

    public static void dec2b(double x, int b, int n, StringBuilder result) {
        x *= b;
        if (0 < x && x < 1) {
            dec2b(x, b, n, result);
        } else {
            result.append((int) x % b);
            if (x - ((int) x) < 0.000001) {
                if (result.length() > n) {
                    System.out.println("The result is: " + "0." + String.valueOf(result.toString()).substring(0, n));
                } else {
                    System.out.println("The result is: " + "0." + result.toString());
                }
            } else {
                dec2b(x - (int) x, b, n, result);
            }
        }
    }
}
