package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Geography: estimate areas
 */
public class Ch4Ex3 {
    public static void main(String[] args) {
        double charlotteX = 35.2270869;
        double charlotteY = -80.8431267;
        double atlantaX = 33.7489957;
        double atlantaY = -84.3879824;
        double savannahX = 32.08835407;
        double savannahY = -81.0998342;
        double orlandoX = 28.5383355;
        double orlandoY = -81.3792365;

        double area = 0.5 * Math.abs(charlotteX * atlantaY - atlantaX * charlotteY + atlantaX * savannahY - savannahX * atlantaY + savannahX * orlandoY - orlandoX * savannahY + orlandoX * charlotteY - charlotteX * orlandoY);
        System.out.printf("The area of four country is %f km^2", area);

    }

//    public static double greatCircleDistance(double x1, double y1, double x2, double y2) {
//        return 6371.01 * Math.acos(Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) + Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) * Math.cos(Math.toRadians(y1) - Math.toRadians(y2)));
//    }
}
