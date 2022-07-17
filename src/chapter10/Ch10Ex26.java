package chapter10;

import java.util.Arrays;

/**
 * @author swarfte
 * @title Calculator
 */
public class Ch10Ex26 {
    public static void main(String[] args) {

        if (args.length == 1) {
            String[] number = args[0].split("[+*/-]");
            if (args[0].contains("+")) {
                System.out.println(Integer.parseInt(number[0]) + Integer.parseInt(number[1]));
            } else if (args[0].contains("-")) {
                System.out.println(Integer.parseInt(number[0]) - Integer.parseInt(number[1]));
            } else if (args[0].contains("*")) {
                System.out.println(Integer.parseInt(number[0]) * Integer.parseInt(number[1]));
            } else if (args[0].contains("/")) {
                System.out.println(Integer.parseInt(number[0]) / Integer.parseInt(number[1]));
            } else if (args[0].contains("%")) {
                System.out.println(Integer.parseInt(number[0]) % Integer.parseInt(number[1]));
            } else {
                System.out.println("Invalid input");
            }
            //double answer = calculate(number[0], number[1],number[2]);
        } else if (args.length == 3) {
            if ("+".equals(args[1])) {
                System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[2]));
            } else if ("-".equals(args[1])) {
                System.out.println(Integer.parseInt(args[0]) - Integer.parseInt(args[2]));
            } else if ("*".equals(args[1])) {
                System.out.println(Integer.parseInt(args[0]) * Integer.parseInt(args[2]));
            } else if ("/".equals(args[1])) {
                System.out.println(Integer.parseInt(args[0]) / Integer.parseInt(args[2]));
            } else if ("%".equals(args[1])) {
                System.out.println(Integer.parseInt(args[0]) % Integer.parseInt(args[2]));
            } else {
                System.out.println("Invalid input");
            }
        }
    }

}
