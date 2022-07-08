package chapter6;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial: credit card number validation
 */
public class Ch6Ex31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a credit card number as a long integer : ");
        long creditCardNumber = scanner.nextLong();
        if (isValid(creditCardNumber)) {
            System.out.println(creditCardNumber + " is valid");
        } else {
            System.out.println(creditCardNumber + " is invalid");
        }

    }

    public static boolean isValid(long number) {
        return getDigit(number) % 10 == 0;
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int count = 0;
        String n = String.valueOf(number);
        for (int i = getSize(number) - 2; i >= 0; i -= 2) {
            int temp = Integer.parseInt(String.valueOf(n.charAt(i))) * 2;
            if (temp > 9) {
                temp = Integer.parseInt(String.valueOf(String.valueOf(temp).charAt(0))) + Integer.parseInt(String.valueOf(String.valueOf(temp).charAt(1)));
            }
            count += temp;
        }
        return count;
    }

    public static int getDigit(long number) {
        return sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
    }

    public static int sumOfOddPlace(long number) {
        int count = 0;
        String n = String.valueOf(number);
        for (int i = getSize(number) - 1; i >= 0; i -= 2) {
            int temp = Integer.parseInt(String.valueOf(n.charAt(i)));
            count += temp;
        }
        return count;
    }

    public static int getSize(long d) {
        return String.valueOf(d).length();
    }

}
