package chapter5;

/**
 * @author swarfte
 * @title Perfect number
 */
public class Ch5Ex33 {
    public static void main(String[] args) {
        int range = 10000;
        int count = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < range; i++) {
            if (isPerfectNumber(i)) {
                output.append(i).append(" ");
                count++;
            }
            if (count == 10) {
                count = 0;
                output.append("\n");
            }
        }
        System.out.println(output.toString());
    }

    public static boolean isPerfectNumber(int number) {
        if (number > 1) {
            int check = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    check += i;
                }
            }
            return check == number;
        } else {
            return false;
        }
    }
}
