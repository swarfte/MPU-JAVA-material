package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find the number of days in a month
 */
public class Ch3Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month and year : ");
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        int day = switch (month) {
            case 1 -> 31;
            case 2 -> 28;
            case 3 -> 31;
            case 4 -> 30;
            case 5 -> 31;
            case 6 -> 30;
            case 7 -> 31;
            case 8 -> 31;
            case 9 -> 30;
            case 10 -> 31;
            case 11 -> 30;
            case 12 -> 31;
            default -> -1;
        };
        String name = switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
        if (month == 2) {
            if (year % 4 == 0) {
                day = 29;
            }
        }
        System.out.printf("%s %d has %d days", name, year, day);

    }
}
