package chapter2;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Population projection
 */
public class Ch2Ex11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int population = 312032486;
        int day = 365;
        int time = 365 * 24 * 60 * 60;
        int birth = time / 7;
        int death = time / 13;
        int immigrant = time / 45;
        System.out.print("Enter the number of years : ");
        int year = scanner.nextInt();


        for (int i = 0; i < year; i++) {
            population = population + birth + immigrant - death;
        }

        System.out.printf("The population in %d years is %d", year, population);
    }
}
