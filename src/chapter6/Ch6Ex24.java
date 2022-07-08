package chapter6;

/**
 * @author swarfte
 * @title Display current date and time
 */
public class Ch6Ex24 {
    public static void main(String[] args) {
        System.out.println(currentDate());
    }

    public static String currentDate() {
        long time = System.currentTimeMillis();
        long second = time / 1000;
        long minutes = second / 60;
        long hour = minutes / 60;

        // I don't know why it worked
        long day = hour / 24 - 16;

        long month = day / 31;
        long year = 1970 + day / 365;
        return String.format("%d/%d/%d %d:%d:%d", year, month % 12 + 1, day % 31 + 1, hour % 24 + 8, minutes % 60, second % 60);
    }

}
