package chapter6;

/**
 * @author swarfte
 * @title Number of days in a year
 */
public class Ch6Ex16 {
    public static void main(String[] args) {
        for (int i = 2014; i <= 2034; i++) {
            System.out.printf("%d : %d\n", i, numberOfDaysInYear(i));
        }
    }

    public static int numberOfDaysInYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? 366 : 365;
    }
}
