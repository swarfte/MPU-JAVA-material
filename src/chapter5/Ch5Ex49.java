package chapter5;

import java.util.Scanner;

/**
 * @author swarft
 * @title Count vowels and consonants
 */
public class Ch5Ex49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.nextLine().toLowerCase();
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else if (Character.isLetter(c)) {
                    consonants++;
                }
            }
        }
        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);
    }
}
