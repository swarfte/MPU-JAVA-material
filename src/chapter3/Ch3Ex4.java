package chapter3;

/**
 * @author swarfte
 * @title Random month
 */
public class Ch3Ex4 {
    public static void main(String[] args) {
        int month = ((int) (Math.random() * 100) % 12) + 1;
        String name = switch (month) {
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
        System.out.print(name);
    }
}
