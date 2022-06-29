package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the number of years
 */
public class Ch2Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of minutes : ");
        int minutes = scanner.nextInt();
        int year = (minutes / 60 / 24) / 365;
        int day = (minutes / 60 / 24) % 365;
        System.out.printf("%d minutes is approximately %d years and %d days ", minutes, year, day);

    }
}
