package chapter11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Sum ArrayList
 */
public class Ch11Ex12 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 number: ");
        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }
        double number = sum(list);
        System.out.println("the sum is " + number);
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        for (double d : list) {
            sum += d;
        }
        return sum;
    }
}
