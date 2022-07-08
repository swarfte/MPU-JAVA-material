package chapter6;

/**
 * @author swarfte
 * @title Display numbers
 */
public class Ch6Ex12 {
    public static void main(String[] args) {
        printNumbers(1, 100, 10);
    }

    public static void printNumbers(int num1, int num2, int numberPerLine) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = num1; i <= num2; i++) {
            sb.append(i).append(" ");
            count++;
            if (count == numberPerLine) {
                count = 0;
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
