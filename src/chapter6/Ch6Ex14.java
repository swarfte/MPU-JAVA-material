package chapter6;

/**
 * @author swarfte
 * @title Estimate PI
 */
public class Ch6Ex14 {
    public static void main(String[] args) {
        System.out.println("i    m(i)");
        System.out.println("-".repeat(15));
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-5d %.4f\n", 1 + i * 100, estimatePi(1 + i * 100));
        }
    }

    public static double estimatePi(int number) {
        double value = 0;
        for (int i = 1; i <= number; i++) {
            value += (Math.pow(-1, i + 1)) / (2 * i - 1);
        }
        return value * 4;
    }
}
