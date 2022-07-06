package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display calendar
 */
public class Ch5Ex29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year and the first days or year : ");
        int year = scanner.nextInt();
        int firstDay = scanner.nextInt();
        StringBuilder calendars = new StringBuilder();
        for (int i = 1; i <= 12; i++) {
            calendars.append(displayCalendars(year, i, firstDay % 7));
            firstDay += getDayOfMonth(i, year);
        }
        System.out.println(calendars);
    }

    public static String displayCalendars(int year, int month, int firstDay) {
        StringBuilder output = new StringBuilder();
        String space = " ";

        //title
        output.append(space.repeat(10)).append(getMonthName(month)).append(" ").append(year).append(space.repeat(10)).append("\n");

        //split line
        output.append("_".repeat(35)).append("\n");

        //day name (two space)
        output.append(" Sun  Mon  Tue  Wed  Thu  Fri  Sat  ").append("\n");

        // add space before start
        output.append(space.repeat(firstDay * 5 + 2));

        // set the count number
        int count = firstDay;

        // add the day in calendars
        for (int i = 1; i <= getDayOfMonth(month, year); i++) {
            int s = 4;
            if (i >= 10) {
                s = 3;
            }
            output.append(i).append(space.repeat(s));
            count++;
            if (count == 7) {
                output.append("\n");
                count = 0;
                output.append(space.repeat(2));
            }
        }

        // add the space for next calendars
        output.append("\n");
        return output.toString();
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

    public static int getDayOfMonth(int month, int year) {
        return switch (month) {
            case 1 -> 31;
            case 2 -> year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
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
