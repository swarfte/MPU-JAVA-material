package chapter6;

/**
 * @author swarfte
 * @title Math: pentagonal number
 */
public class Ch6Ex1 {
    public static void main(String[] args) {
        int count = 0;
        int range = 100;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < range; i++) {
            sb.append("%7d".formatted(getPentagonalNumber(i)));
            count++;
            if (count == 10) {
                sb.append("\n");
                count = 0;
            }
        }
        System.out.println(sb.toString());
    }

    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }
}
