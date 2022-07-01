package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Find future dates
 */
public class Ch3Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter today's day : ");
        int today = scanner.nextInt();
        String todayName = selectDay(today);
        System.out.print("Enter the number of days elapsed since today : ");
        int nextDay = scanner.nextInt();
        int futureDay = (today + nextDay) % 7;
        String FutureDayName = selectDay(futureDay);
        System.out.printf("Today is %s and the future day is %s", todayName, FutureDayName);

    }

    private static String selectDay(int today) {
        return switch (today) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }
}
