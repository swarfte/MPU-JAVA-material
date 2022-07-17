package chapter10;

import java.util.GregorianCalendar;

/**
 * @author swarfte
 * @title The MyDate class
 */
public class Ch10Ex14 {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate();
        MyDate myDate2 = new MyDate(34355555133101L);
        System.out.println("The current date is " + myDate1.getYear() + "-" + myDate1.getMonth() + "-" + myDate1.getDay());
        System.out.println("The date is " + myDate2.getYear() + "-" + myDate2.getMonth() + "-" + myDate2.getDay());
    }
}

/**
 * UML diagram
 * <p>
 * MyDate
 * <p>
 * - year:int
 * <p>
 * - month:int
 * <p>
 * - day:int
 * <p>
 * + MyDate()
 * <p>
 * + MyDate(elapsedTime: long)
 * <p>
 * + MyDate(year: int, month: int, day: int)
 * <p>
 * + getYear(): int
 * <p>
 * + getMonth(): int
 * <p>
 * + getDay(): int
 * <p>
 * + setDate(elapsedTime): long
 */

class MyDate {
    private int year;
    private int month;
    private int day;

    MyDate() {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(long elapsedTime) {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public long setDate(long elapsedTime) {
        GregorianCalendar calendar = new java.util.GregorianCalendar();
        calendar.setTimeInMillis(elapsedTime);
        year = calendar.get(java.util.Calendar.YEAR);
        month = calendar.get(java.util.Calendar.MONTH);
        day = calendar.get(java.util.Calendar.DAY_OF_MONTH);
        return calendar.getTimeInMillis();
    }
}
