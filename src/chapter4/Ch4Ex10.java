package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Guess birthday
 */
public class Ch4Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String set1 = """
                1 3 5 7\s
                9 11 13 15\s
                17 19 21 13\s
                25 27 29 31""";
        String set2 = """
                2 3 6 7\s
                10 11 14 15\s
                18 19 22 23\s
                26 27 30 31""";
        String set3 = """
                4 5 6 7\s
                12 13 14 15\s
                20 21 22 23\s
                28 29 30 31""";
        String set4 = """
                8 9 10 11\s
                12 13 14 15\s
                24 25 26 27\s
                28 29 30 31""";
        String set5 = """
                16 17 18 19\s
                20 21 22 23\s
                24 25 26 27\s
                28 29 30 31""";

        int day = 0;

        System.out.println("Is your birthday in Set1?");
        System.out.println(set1);
        System.out.print("Enter N for No and Y for Yes : ");
        String answer = scanner.next();
        if ("Y".equals(answer)) {
            day += 1;
        }

        System.out.println("Is your birthday in Set2?");
        System.out.println(set1);
        System.out.print("Enter N for No and Y for Yes : ");
        answer = scanner.next();
        if ("Y".equals(answer)) {
            day += 2;
        }

        System.out.println("Is your birthday in Set3?");
        System.out.println(set1);
        System.out.print("Enter N for No and Y for Yes : ");
        answer = scanner.next();
        if ("Y".equals(answer)) {
            day += 4;
        }

        System.out.println("Is your birthday in Set4?");
        System.out.println(set1);
        System.out.print("Enter N for No and Y for Yes : ");
        answer = scanner.next();
        if ("Y".equals(answer)) {
            day += 8;
        }

        System.out.println("Is your birthday in Set5?");
        System.out.println(set1);
        System.out.print("Enter N for No and Y for Yes : ");
        answer = scanner.next();
        if ("Y".equals(answer)) {
            day += 16;
        }

        System.out.printf("Your birthday is %d day !", day);
    }
}
