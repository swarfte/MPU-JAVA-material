package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Print calendar
 */
public class Ch6Ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full year (e.g., 2012) : ");
        int year = scanner.nextInt();
        System.out.print("Enter month as a number between 1 and 12 : ");
        int month = scanner.nextInt();
        printMonth(year, month);

    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);

        printMonthBody(year, month);
    }

    public static void printMonthBody(int year, int month) {
        int startDay = zellerCongruence(year, month, 1) - 1;
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        int i = 0;
        for (i = 0; i < startDay; i++) {
            System.out.print(" ".repeat(5));
        }

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%5d", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();

    }

    public static void printMonthTitle(int year, int month) {
        System.out.println(" ".repeat(10) + getMonthName(month) + " " + year);
        System.out.println("-".repeat(40));
        System.out.println("  Sun  Mon  Tue  Wed  Thu  Fri  Sat");
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static int zellerCongruence(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year -= 1;
        }
        int value = (day + (26 * (month + 1) / 10) + (year % 100) + ((year % 100) / 4) + (year / 100 / 4) + (5 * year / 100)) % 7;

        return value == 0 ? 6 : value - 1;
    }


    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
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
}
