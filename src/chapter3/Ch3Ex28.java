package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geometry : two rectangles
 */
public class Ch3Ex28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter r1's center x- y- coordinates, width, and height : ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double w1 = scanner.nextDouble();
        double h1 = scanner.nextDouble();

        // get the 4 point of the first rectangles corner
        double leftUpX1 = x1 - w1 / 2;
        double leftUpY1 = y1 + h1 / 2;
        double rightUpX1 = x1 + w1 / 2;
        double rightUpY1 = y1 + h1 / 2;
        double rightDownX1 = x1 + w1 / 2;
        double rightDownY1 = y1 - h1 / 2;
        double leftDownX1 = x1 - w1 / 2;
        double leftDownY1 = y1 - h1 / 2;

        System.out.print("Enter r2's center x- y- coordinates, width, and height : ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double w2 = scanner.nextDouble();
        double h2 = scanner.nextDouble();

        // get the 4 point oft the second rectangles corner

        double leftUpX2 = x2 - w2 / 2;
        double leftUpY2 = y2 + h2 / 2;
        double rightUpX2 = x2 + w2 / 2;
        double rightUpY2 = y2 + h2 / 2;
        double rightDownX2 = x2 + w2 / 2;
        double rightDownY2 = y2 - h2 / 2;
        double leftDownX2 = x2 - w2 / 2;
        double leftDownY2 = y2 - h2 / 2;

        double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), 0.5);

        // determine the second rectangles corner location
        if ((leftUpX2 > leftUpX1 && leftUpY2 < leftUpY1)
                && (rightUpX2 < rightUpX1 && rightUpY2 < rightUpY1)
                && (rightDownX2 < rightDownX1 && rightDownY2 > rightDownY1)
                && (leftDownX2 > leftDownX1 && leftDownY2 > leftDownY1)) {
            System.out.println("r2 is inside r1");
            // determined the length of two point
        } else if (distance > (w1 / 2 + w2 / 2)) {
            System.out.println("R2 does not overlap r1");
        } else {
            System.out.println("r2 is overlaps r1");
        }
    }
}
