package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Print a table
 */
public class Ch2Ex18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x1 and y1 : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2 and y2 : ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double middleX = (x1 + x2) / 2;
        double middleY = (y1 + y2) / 2;
        System.out.printf("The middle point is (%f , %f)", middleX, middleY);
    }
}
