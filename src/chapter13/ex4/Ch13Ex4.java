package chapter13.ex4;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author swarfte
 * @title Display calendars
 */
public class Ch13Ex4 {
    public static void main(String[] args) throws Exception {
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        GregorianCalendar calendar = new GregorianCalendar(year, getMonth(month), 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(" ".repeat(10) + getMonthName(month) + ", " + year);
        System.out.println("-".repeat(30));
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");
        int count = startDay;
        int day = 1;
        System.out.print("    ".repeat(count - 1));
        while (daysInMonth > 0) {
            while (count <= 7 && daysInMonth > 0) {
                System.out.printf("%3d ", day);
                day++;
                daysInMonth--;
                count++;
            }
            count = 1;
            System.out.println();
        }
    }

    public static int getMonth(int month) {
        return switch (month) {
            case 1 -> Calendar.JANUARY;
            case 2 -> Calendar.FEBRUARY;
            case 3 -> Calendar.MARCH;
            case 4 -> Calendar.APRIL;
            case 5 -> Calendar.MAY;
            case 6 -> Calendar.JUNE;
            case 7 -> Calendar.JULY;
            case 8 -> Calendar.AUGUST;
            case 9 -> Calendar.SEPTEMBER;
            case 10 -> Calendar.OCTOBER;
            case 11 -> Calendar.NOVEMBER;
            case 12 -> Calendar.DECEMBER;
            default -> 0;
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
            default -> "";
        };
    }
}
