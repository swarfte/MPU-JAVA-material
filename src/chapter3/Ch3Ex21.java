package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Science : day of the week
 */
public class Ch3Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year : (e.g., 2012) : ");
        int year = scanner.nextInt();
        System.out.print("Enter month : 1-12 : ");
        int month = scanner.nextInt();
        if (month == 1 || month == 2) {
            month += 12;
            year -= 1;
        }
        System.out.print("Enter the day of the month : 1-31 : ");
        int day = scanner.nextInt();
        int dayOfWeek = (day + (26 * (month + 1) / 10) + (year % 100) + ((year % 100) / 4) + (year / 100 / 4) + (5 * year / 100)) % 7;
        String name = switch (dayOfWeek) {
            case 0 -> "Saturday";
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
            case 5 -> "Thursday";
            case 6 -> "Friday";
            default -> "";
        };
        System.out.printf("Day of the week is %s", name);
    }
}
