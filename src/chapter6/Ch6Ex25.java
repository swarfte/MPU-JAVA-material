package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Convert milliseconds to hours, minutes, and seconds
 */
public class Ch6Ex25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a long integer for milliseconds : ");
        long millis = scanner.nextLong();
        System.out.println(convertMillis(millis));
    }

    public static String convertMillis(long millis) {
        long second = millis / 1000;
        long minutes = second / 60;
        long hours = minutes / 60;
        return String.format("%d:%d:%d", hours, minutes % 60, second % 60);
    }
}
