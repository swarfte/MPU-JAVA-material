package chapter3;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game : scissor , rock , paper
 */
public class Ch3Ex17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("scissor (0), rock (1) , paper (2) : ");
        int guess = scanner.nextInt(); // tail
        int computer = (int) (Math.random() * 3); // head

        String tail = switch (guess) {
            case 0 -> "scissor";
            case 1 -> "rock";
            case 2 -> "paper";
            default -> "";
        };

        String head = switch (computer) {
            case 0 -> "scissor";
            case 1 -> "rock";
            case 2 -> "paper";
            default -> "";
        };

        if (guess == 0 && computer == 2 || guess == 1 && computer == 0 || guess == 2 && computer == 1) {
            System.out.printf("The computer is %s . You are %s . You win", head, tail);
        } else if (guess == 2 && computer == 0 || guess == 0 && computer == 1 || guess == 1 && computer == 2) {
            System.out.printf("The computer is %s . You are %s . You lose", head, tail);
        } else {
            System.out.printf("The computer is %s . You are %s too . It is a draw", head, tail);
        }
    }
}
