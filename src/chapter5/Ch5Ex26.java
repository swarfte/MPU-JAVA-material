package chapter5;

/**
 * @author swarfte
 * @title compute e
 */
public class Ch5Ex26 {
    public static void main(String[] args) {
        for (int i = 10000; i <= 100000; i += 10000) {
            System.out.println(computeE(i));
        }
    }

//    public static double computeE(int end) {
//        double value = 0;
//        for (int i = 0; i <= end; i++) {
//            value += 1.0 / factorial(i);
//        }
//        return value;
//    }

    public static double computeE(int end) {
        double e = 2;
        double item = 1;
        for (int i = 2; i <= end; i++) {
            item /= i;
            e += item;
        }
        return e;
    }

    public static long factorial(int number) {
        long value = 1;
        if (number > 1) {
            for (int i = number; i > 0; i--) {
                value *= i;
            }
        }
        return value;
    }
}
