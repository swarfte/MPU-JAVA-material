package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display the first days of each month
 */
public class Ch5Ex28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year and the first days or year : ");
        int year = scanner.nextInt();
        int firstDay = scanner.nextInt();
        int isLeap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 1 : 0;
        for (int i = 1; i <= 12; i++) {
            if (i != 2) {
                System.out.printf("%s 1, %d is %s\n", getMonthName(i), year, getDayName(firstDay % 7));
            } else {
                System.out.printf("%s 1, %d is %s\n", getMonthName(i), year, getDayName((firstDay + isLeap) % 7));
            }
            firstDay += getDayOfMonth(i);
        }
    }

    public static String getDayName(int day) {
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Error";
        };
    }

    public static String getMonthName(int month) {
        return switch (month) {
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
            default -> "Error";
        };
    }

    public static int getDayOfMonth(int month) {
        return switch (month) {
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
            default -> 0;
        };
    }

}
