package chapter5;

/**
 * @author swarfte
 * @title Find number divisible by 3 and 4
 */
public class Ch5Ex10 {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();
        int number = 0;
        for (int i = 100; i < 1000; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                line.append(i).append(" ");
                number += 1;
            }
            if (number == 10) {
                line.append("\n");
                number = 0;
            }
        }
        System.out.println(line.toString());
    }
}
