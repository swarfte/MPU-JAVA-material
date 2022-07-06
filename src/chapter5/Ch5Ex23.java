package chapter5;

/**
 * @author swarfte
 * @title Demonstrate cancellation errors
 */
public class Ch5Ex23 {
    public static void main(String[] args) {
        System.out.println(fromLeftToRight(50000));
        System.out.println(fromRightToLeft(50000));
    }

    public static double fromLeftToRight(int end) {
        double value = 0;
        for (int i = 1; i <= end; i++) {
            value += 1.0 / i;
        }
        return value;
    }

    public static double fromRightToLeft(int end) {
        double value = 0;
        for (int i = end; i >= 1; i--) {
            value += 1.0 / i;
        }
        return value;
    }
}
