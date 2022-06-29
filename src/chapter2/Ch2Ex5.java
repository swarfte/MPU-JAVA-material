package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial application : calculate tips
 */
public class Ch2Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the subtotal and a gratuity rate : ");
        double subtotal = scanner.nextDouble();
        double gratuityRate = scanner.nextDouble();
        double gratuity = subtotal * (gratuityRate / 100);
        double total = gratuity + subtotal;
        System.out.printf("The gratuity is $%f and total is $%f", gratuity, total);

    }
}
