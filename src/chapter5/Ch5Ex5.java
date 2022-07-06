package chapter5;

/**
 * @author swarfte
 * @title Conversion from C to F and F to C
 */
public class Ch5Ex5 {
    public static void main(String[] args) {
        System.out.println("Celsius    Fahrenheit    |    Fahrenheit    Celsius");
        for (int i = 0; i <= 50; i++) {
            System.out.printf("%-10d %-14f|    %-13d %-4f\n", i * 2, i * 2 * 9.0 / 5 + 32, 20 + i * 5, (20 + i * 5 - 32) * 5.0 / 9);
        }
    }
}
