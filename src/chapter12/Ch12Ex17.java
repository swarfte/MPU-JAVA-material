package chapter12;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author swarfte
 * @title Game: hangman
 */
public class Ch12Ex17 {
    public static void main(String[] args) throws Exception {
        String check = "y";
        File file = new File(args[0]);
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }
        String[] words = lines.toArray(new String[0]);
        while (check.contains("y")) {

            Scanner scanner = new Scanner(System.in);
            int index = (int) (Math.random() * words.length);
            StringBuilder answer = new StringBuilder(words[index]);
            StringBuilder question = new StringBuilder(buildQuestion(words[index]));
            int missedTime = 0;

            while (question.toString().contains("*")) {
                if (!answerQuestion(answer, question)) {
                    missedTime++;
                }
            }

            System.out.println("THe word is " + answer + ". You missed " + missedTime + " times.");
            System.out.print("Do you want to guess another word? Enter y or n > ");
            check = scanner.next();
        }

    }

    public static String buildQuestion(String answer) {
        return "*".repeat(answer.length());
    }

    public static boolean answerQuestion(StringBuilder answer, StringBuilder question) {
        System.out.print("(Guess) Enter a letter in word " + question + " > ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();


        if (question.toString().contains(input)) {
            System.out.println(input + " is already in the word");
            return false;

        } else if (!answer.toString().contains(input)) {
            System.out.println(input + " is not in the word");
            return false;

        } else {
            for (int i = 0; i < answer.length(); i++) {
                if (answer.charAt(i) == input.charAt(0)) {
                    question.setCharAt(i, input.charAt(0));
                }
            }
            return true;
        }
    }
}
