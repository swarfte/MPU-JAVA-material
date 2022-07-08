package chapter6;

/**
 * @author swarfte
 * @title Conversions between mile and kilometers
 */
public class Ch6Ex8 {
    public static void main(String[] args) {
        System.out.println("Miles       Kilometers    |    Kilometers    Miles");
        System.out.println("-".repeat(60));
        int number = 10;
        for (int i = 1; i <= number; i++) {
            System.out.printf("%-10d %11f    |     %-10d    %f\n", i, mileToKilometer(i), 5 * i + 15, kilometerToMile(5 * i + 15));
        }
    }

    public static double mileToKilometer(double mile) {
        return mile * 1.6;
    }

    public static double kilometerToMile(double kilometer) {
        return kilometer / 1.6;
    }

}
