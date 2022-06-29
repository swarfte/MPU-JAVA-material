package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Convert square meter into ping
 */
public class Ch2Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ping = 0.3025;
        System.out.print("Enter a number in square meters : ");
        double meters = scanner.nextDouble();
        System.out.printf("%f square meters is %f pings", meters, ping * meters);
    }
}
