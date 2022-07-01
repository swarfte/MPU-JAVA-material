package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Financial : compare costs
 */
public class Ch3Ex33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight and price for package 1 : ");
        double weight1 = scanner.nextDouble();
        double price1 = scanner.nextDouble();
        System.out.print("Enter weight and price for package 2 : ");
        double weight2 = scanner.nextDouble();
        double price2 = scanner.nextDouble();
        double rate = weight1 / weight2;
        price1 /= rate;
        if (price1 < price2) {
            System.out.print("Package 1 has a better price");
        } else if (price1 > price2) {
            System.out.print("Package 2 has a better price");
        } else if (price1 - price2 < 0.000000000001) {
            System.out.print("Two packages have the same price");
        }
    }
}