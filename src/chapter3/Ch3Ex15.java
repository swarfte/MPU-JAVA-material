package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: lottery
 */
public class Ch3Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your lottery pick (three digits) : ");
        int lottery = (int) (Math.random() * 1000);
        int guess = scanner.nextInt();

        int lotteryDigit1 = lottery / 100;
        int lotteryDigit2 = (lottery % 100) / 10;
        int lotteryDigit3 = lottery % 10;

        int guessDigit1 = guess / 100;
        int guessDigit2 = (guess % 100) / 10;
        int guessDigit3 = guess % 10;

        System.out.printf("The lottery number is %d \n", lottery);
        if (guess == lottery) {
            System.out.println("Exact match : you win $12000");
        } else if ((guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit2)
                || (guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit3)
                || (guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit1)
                || (guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit2)
                || (guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit1)) {
            System.out.println("Match all digits : you win $5000");
        } else if ((guessDigit1 == lotteryDigit1 || guessDigit2 == lotteryDigit1 || guessDigit3 == lotteryDigit1)
                || (guessDigit1 == lotteryDigit2 || guessDigit2 == lotteryDigit2 || guessDigit3 == lotteryDigit2)
                || (guessDigit1 == lotteryDigit3 || guessDigit2 == lotteryDigit3 || guessDigit3 == lotteryDigit3)) {
            System.out.println("Match one digit : you win $2000");
        } else {
            System.out.println("Sorry , no match");
        }
    }
}
