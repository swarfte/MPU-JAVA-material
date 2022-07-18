package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Algebra: perfect square
 */
public class Ch11Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a integer: ");
        int number = scanner.nextInt();
        int result = perfectSquare(number);
        System.out.println("The smallest number n for m * n to be a perfect square is " + result);
        System.out.println("m * n is " + (number * result));

    }

    public static int perfectSquare(int number) {
        ArrayList<Integer> factorsOfNumber = factors(number);
        int result = 1;
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < factorsOfNumber.size(); i++) {
            if (count(factorsOfNumber, factorsOfNumber.get(i)) % 2 != 0 && !count.contains(factorsOfNumber.get(i))) {
                result *= factorsOfNumber.get(i);
                count.add(factorsOfNumber.get(i));
            }
        }
        return result;
    }

    public static int count(ArrayList<Integer> factorsOfNumber, int number) {
        int count = 0;
        for (int i = 0; i < factorsOfNumber.size(); i++) {
            if (factorsOfNumber.get(i) == number) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> factors(int number) {
        ArrayList<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number; ) {
            if (number % i == 0) {
                factors.add(i);
                number /= i;
            } else {
                i++;
            }
        }
        return factors;
    }
}
