package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Days of a month
 */
public class Ch4Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year : ");
        int year = scanner.nextInt();
        int febMonth = year % 4 == 0 ? 29 : 28;
        System.out.print("Enter a month : ");
        String month = scanner.next();
        String result = switch (month) {
            case "Jan" -> "Jan " + year + " has 31 days";
            case "Feb" -> "Feb " + year + " has " + febMonth + " days ";
            case "Mar" -> "Mar " + year + " has 31 days";
            case "Apr" -> "Apr " + year + " has 30 days";
            case "May" -> "May " + year + " has 31 days";
            case "Jun" -> "Jun " + year + " has 30 days";
            case "Jul" -> "Jul " + year + " has 31 days";
            case "Aug" -> "Aug " + year + " has 31 days";
            case "Sep" -> "Sep " + year + " has 30 days";
            case "Oct" -> "Oct " + year + " has 31 days";
            case "Nov" -> "Nov " + year + " has 30 days";
            case "Dec" -> "Dec " + year + " has 31 days";
            default -> month + "is not a correct month name";
        };
        System.out.print(result);
    }
}
