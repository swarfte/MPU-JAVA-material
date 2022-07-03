package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry: area of a regular polygon
 */
public class Ch4Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sides : ");
        double numberOfSide = scanner.nextDouble();
        System.out.print("Enter the side : ");
        double lengthOfSide = scanner.nextDouble();
        double area = (numberOfSide * Math.pow(lengthOfSide, 2)) / (4 * Math.tan(Math.PI / numberOfSide));
        System.out.printf("The area of the polygon is %f", area);
    }
}
