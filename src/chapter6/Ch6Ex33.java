package chapter6;

/**
 * @author swarfte
 * @title Current date and time
 */
public class Ch6Ex33 {
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
        return String.format("Current date and time is %s %d , %d %02d:%02d:%02d", monthName((int) (month % 12 + 1)), day % 31 + 1, year, hour % 24 + 8, minutes % 60, second % 60);
    }

    public static String monthName(int month) {
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
            default -> "Error";
        };
    }
}
