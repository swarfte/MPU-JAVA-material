package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ex1 {
    public static void main(String[] args) {
        double mile = 1.6;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter miles : ");
        double input = scanner.nextDouble();
        System.out.printf("%f miles is %f kilometers", input, input * mile);


    }
}
