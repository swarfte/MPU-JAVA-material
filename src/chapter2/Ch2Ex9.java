package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Physics:acceleration
 */
public class Ch2Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter v0, v1, and t :");
        double v0 = scanner.nextDouble();
        double v1 = scanner.nextDouble();
        double time = scanner.nextDouble();
        double acceleration = (v1 - v0) / time;
        System.out.printf("The average acceleration is %f", acceleration);
    }
}
