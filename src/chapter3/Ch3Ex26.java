package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Use the && , || and ^ operators
 */
public class Ch3Ex26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int number = scanner.nextInt();
        boolean fourAndFive = number % 4 == 0 && number % 5 == 0;
        boolean fourOrFive = number % 4 == 0 || number % 5 == 0;
        boolean fourXorFive = number % 4 == 0 ^ number % 5 == 0;
        System.out.printf("Is %d divisible by 4 and 5 ? %b\n", number, fourAndFive);
        System.out.printf("Is %d divisible by 4 or 5 ? %b\n", number, fourOrFive);
        System.out.printf("Is %d divisible by 4 or 5 but not both ? %b\n", number, fourXorFive);
    }
}
