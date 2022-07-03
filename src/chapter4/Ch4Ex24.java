package chapter4;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Enter three countries
 */
public class Ch4Ex24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first country : ");
        String firstCountry = scanner.nextLine();
        System.out.print("Enter the second country : ");
        String secondCountry = scanner.nextLine();
        System.out.print("Enter the third country : ");
        String thirdCountry = scanner.nextLine();

        if (firstCountry.compareTo(secondCountry) < 0) {
            String temp = firstCountry;
            firstCountry = secondCountry;
            secondCountry = temp;
        }
        if (secondCountry.compareTo(thirdCountry) < 0) {
            String temp = secondCountry;
            secondCountry = thirdCountry;
            thirdCountry = temp;
        }
        if (firstCountry.compareTo(secondCountry) < 0) {
            String temp = firstCountry;
            firstCountry = secondCountry;
            secondCountry = temp;
        }
        System.out.printf("The three countries in descending order are %s %s %s", firstCountry, secondCountry, thirdCountry);
    }
}
