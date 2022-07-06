package chapter5;

/**
 * @author swarfte
 * @title Conversion from inch to centimeter
 */
public class Ch5Ex4 {
    public static void main(String[] args) {
        System.out.println("Inches    Centimetres");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-10d %f\n", i, i * 2.54);
        }
    }
}
