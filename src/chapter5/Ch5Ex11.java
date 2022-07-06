package chapter5;

/**
 * @author swarfte
 * @title Find number divisible by 3 or 4 , but not both
 */
public class Ch5Ex11 {
    public static void main(String[] args) {
        StringBuilder line = new StringBuilder();
        int number = 0;
        for (int i = 100; i < 200; i++) {
            if (i % 3 == 0 ^ i % 4 == 0) {
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
