package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Month name
 */
public class Ch7Ex33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a month number: ");
        int month = scanner.nextInt();
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        System.out.println("The month name is: " + monthNames[month - 1]);
    }
}
