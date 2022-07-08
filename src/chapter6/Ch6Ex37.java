package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Format an integer
 */
public class Ch6Ex37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        int number = scanner.nextInt();
        System.out.print("Enter its width : ");
        int width = scanner.nextInt();
        System.out.print(format(number, width));
    }

    public static String format(int number, int width) {
        String str = Integer.toString(number);
        int length = str.length();
        if (length < width) {
            for (int i = 0; i < width - length; i++) {
                str = "0" + str;
            }
        }
        return str;
    }
}
