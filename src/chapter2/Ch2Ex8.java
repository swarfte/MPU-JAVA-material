package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Current time
 */
public class Ch2Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the time zone offset to GMT :");
        long milliseconds = System.currentTimeMillis();
        long hours = (milliseconds / 1000 / 60 / 60) % 24;
        long minutes = (milliseconds / 1000 / 60) % 60;
        long seconds = (milliseconds / 1000) % 60;
        int timeZone = scanner.nextInt();
        hours = (hours + timeZone) % 24;
        System.out.printf("The current time is %d:%d:%d", hours, minutes, seconds);

    }
}
