package chapter5;

/**
 * @author swarfte
 * @title Conversion from C to F
 */

public class Ch5Ex3 {
    public static void main(String[] args) {
        System.out.println("Celsius    Fahrenheit");
        for (int i = 0; i <= 100; i += 2) {
            System.out.printf("%-10d %f\n", i, i * 9.0 / 5 + 32);
        }
    }
}
