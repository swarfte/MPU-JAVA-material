package chapter12;

import java.util.Scanner;

/**
 * @author swarfte
 * @title ArrayIndexOutOfBoundsException
 */
public class Ch12Ex2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the an integer between 1 and 12 : ");
        int num = scanner.nextInt() - 1;
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try {
            System.out.println(months[num] + " " + dom[num] + " days");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong number");
        }
    }
}
