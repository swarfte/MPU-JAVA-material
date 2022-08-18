package chapter18.ex4;

/**
 * @author swarfte
 */
public class Ch18Ex4 {
    public static void main(String[] args) throws Exception {
        System.out.println(C(10, 5));
    }

    public static long C(long n, long p) {
        if (p == 0) {
            return 1;
        } else if (n == p) {
            return 1;
        } else {
            return C(n - 1, p) + C(n - 1, p - 1);
        }
    }
}
