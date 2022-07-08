package chapter6;

/**
 * @author swarfte
 * @title Emirp ( prime spelled backward )
 */
public class Ch6Ex27 {
    public static void main(String[] args) {
        int size = 120;
        int i = 0;
        int number = 2;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (i < size) {
            if (!isPalindromePrime(number) && isPrime(number) && isPrime(reverse(number))) {
                i++;
                count++;
                sb.append(number).append(' ');
            }
            if (count == 10) {
                count = 0;
                sb.append("\n");
            }
            number++;
        }
        System.out.println(sb.toString());
    }

    public static boolean isPalindromePrime(int number) {
        return isPrime(number) && isPalindrome(number);
    }

    public static int reverse(int number) {
        String original = String.valueOf(number);
        StringBuilder reverseOriginal = new StringBuilder();
        for (int i = 0; i < original.length(); i++) {
            reverseOriginal.insert(0, original.charAt(i));
        }
        return Integer.parseInt(reverseOriginal.toString());
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
