package chapter9;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author swarfte
 * @title Use the GregorianCalendar class
 */
public class Ch9Ex5 {
    public static void main(String[] args) {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        System.out.println("THe current year is " + calendar.get(java.util.Calendar.YEAR) + " month is " + calendar.get(java.util.Calendar.MONTH) + " day is " + calendar.get(java.util.Calendar.DAY_OF_MONTH));
        calendar.setTimeInMillis(1234567898765L);
        System.out.println("The date is " + calendar.get(java.util.Calendar.YEAR) + " month is " + calendar.get(java.util.Calendar.MONTH) + " day is " + calendar.get(java.util.Calendar.DAY_OF_MONTH));
    }
}
