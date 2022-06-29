package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Convert meters into feet
 */
public class Ch2Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for meter : ");
        double feet = 3.2786;
        double meters = scanner.nextDouble();
        System.out.printf("%f meters is %f feet", meters, feet * meters);
    }

}
