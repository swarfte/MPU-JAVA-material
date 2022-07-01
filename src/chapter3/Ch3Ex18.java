package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Cost of shipping
 */
public class Ch3Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the weight of the package : ");
        double weight = scanner.nextDouble();
        double cost = 0;
        if (weight > 0) {
            if (weight <= 2) {
                cost = 2.5;
            } else if (weight <= 4) {
                cost = 4.5;
            } else if (weight <= 10) {
                cost = 7.5;
            } else if (weight <= 20) {
                cost = 10.5;
            } else {
                System.out.println("The package cannot be shipped");
            }
        }
        if (cost > 0) {
            System.out.printf("the shipping cost is %f", cost);
        }
    }
}
