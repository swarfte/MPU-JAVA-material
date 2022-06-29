package chapter1;

/**
 * @author swarfte
 */
public class Ex7 {
    public static void main(String[] args) {
        double v = 1 - 1.0 / 3 + 1.0 / 5 - 1.0 / 7 + 1.0 / 9 - 1.0 / 11;
        double pi1 = 4 * v;
        double pi2 = 4 * (v + 1.0 / 13);
        System.out.println(pi1);
        System.out.println(pi2);

    }
}
