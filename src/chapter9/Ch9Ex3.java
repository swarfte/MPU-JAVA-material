package chapter9;

import java.util.Date;

/**
 * @author swarfte
 * @title Use the Date class
 */
public class Ch9Ex3 {
    public static void main(String[] args) {
        for (long i = 10000; i <= 100000000000L; i *= 10) {
            Date date = new Date(i);
            System.out.println(date.toString());
        }
    }
}
