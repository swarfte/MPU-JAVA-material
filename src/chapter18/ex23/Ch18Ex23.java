package chapter18.ex23;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Binary to decimal
 */
public class Ch18Ex23 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = input.next();
        System.out.println("Decimal: " + bin2Dec(binary));

    }

    public static int bin2Dec(String binaryString) {
        if (binaryString.length() > 0) {
            if (binaryString.charAt(0) == '1') {
                return (int) Math.pow(2, binaryString.length() - 1) + bin2Dec(binaryString.substring(1));
            } else {
                return bin2Dec(binaryString.substring(1));
            }
        } else {
            return 0;
        }
    }
}
