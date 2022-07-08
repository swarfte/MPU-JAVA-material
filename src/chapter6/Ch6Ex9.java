package chapter6;

/**
 * @author swarfte
 * @title Conversions between pounds and kilograms
 */
public class Ch6Ex9 {
    public static void main(String[] args) {
        System.out.println("Kilograms    Pounds    |    Pounds    Kilograms");
        System.out.println("-".repeat(50));
        int number = 100;
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10d %f    |    %-10d %f\n", 1 + i * 2, kilogramToPound(1 + i * 2), i * 5 + 20, poundToKilogram(i * 5 + 20));
        }
    }

    public static double poundToKilogram(double pound) {
        return 2.204 * pound;
    }

    public static double kilogramToPound(double kilogram) {
        return 0.453 * kilogram;
    }
}
