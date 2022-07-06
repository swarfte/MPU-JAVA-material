package chapter5;

/**
 * @author swarfte
 * @title Display leap years
 */
public class Ch5Ex27 {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (int i = 2014; i <= 2114; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                output.append(i).append(" ");
                count++;
            }
            if (count == 10) {
                output.append("\n");
                count = 0;
            }
        }
        System.out.println(output);
    }
}
