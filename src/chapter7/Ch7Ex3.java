package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Count occurrence of number
 */
public class Ch7Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 50 : ");
        int check = -1;
        int[] numbers = new int[50];
        while (true) {
            check = scanner.nextInt();
            if (check <= 0) {
                break;
            }
            numbers[check - 1]++;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                if (numbers[i] == 1) {
                    System.out.printf("%d occurs %d time\n", i + 1, numbers[i]);
                } else {
                    System.out.printf("%d occurs %d times\n", i + 1, numbers[i]);
                }
            }
        }
    }

}
