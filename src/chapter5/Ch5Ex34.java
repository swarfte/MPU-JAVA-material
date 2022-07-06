package chapter5;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Game: scissor, rock , paper
 */
public class Ch5Ex34 {
    public static void main(String[] args) {
        int com = 0;
        int player = 0;
        Scanner scanner = new Scanner(System.in);
        while (com < 3 && player < 3) {
            System.out.print("scissor (0), rock (1) , paper (2) : ");
            int guess = scanner.nextInt();
            int computer = (int) (Math.random() * 3);

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
                System.out.printf("The computer is %s . You are %s . You win\n", head, tail);
                player++;
                com = 0;
            } else if (guess == 2 && computer == 0 || guess == 0 && computer == 1 || guess == 1 && computer == 2) {
                System.out.printf("The computer is %s . You are %s . You lose\n", head, tail);
                com++;
                player = 0;
            } else {
                System.out.printf("The computer is %s . You are %s too . It is a draw\n", head, tail);
            }
        }

    }
}
