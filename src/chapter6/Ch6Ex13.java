package chapter6;

/**
 * @author swarfte
 * @title Sum series
 */
public class Ch6Ex13 {
    public static void main(String[] args) {
        int size = 20;
        System.out.println("l    m(i)");
        System.out.println("-".repeat(15));
        for (int i = 1; i <= size; i++) {
            System.out.printf("%-5d %f\n", i, series(i));
        }
    }

    public static double series(int number) {
        double value = 0.0;
        for (int i = 1; i <= number; i++) {
            value += (double) i / (i + 2);
        }
        return value;
    }
}
