package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Display pyramid
 */
public class Ch5Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of lines : ");
        int line = scanner.nextInt();
        for (int i = line; i > 0; i--) {
            System.out.println(getPalindrome(i));
        }
    }

    public static String getPalindrome(int size) {
        return getPalindrome(size, size, false, "");
    }

    public static String getPalindrome(int size, int currentNumber, boolean increased, String output) {
        if (size > 1) {

            // each turn add one number
            output += currentNumber + " ";

            // the last one digit
            if (size == currentNumber && increased) {
                return output;
            }

            // when the number order is decreasing
            if (currentNumber > 1 && !increased) {
                return getPalindrome(size, currentNumber - 1, increased, output);

                // when the number is the middle in the String
            } else if (currentNumber == 1 && !increased) {
                return getPalindrome(size, currentNumber + 1, !increased, output);

                // when the number order is increasing
            } else if (currentNumber > 1 && increased) {
                return getPalindrome(size, currentNumber + 1, increased, output);
            }

            // collect remain stack
            return "";
        } else {
            // if only one character , just return it
            return "" + size;
        }
    }
}

