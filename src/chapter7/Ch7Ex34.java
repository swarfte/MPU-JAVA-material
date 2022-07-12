package chapter7;

import java.util.Scanner;

/**
 * @author swarfte
 * @title Sort characters in a string
 */
public class Ch7Ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = scanner.next();
        String sortedStr = sort(str);
        System.out.print("The sorted string is : " + sortedStr);

    }

    public static String sort(String str) {

        // separate the string into characters
        char[] charArray = str.toCharArray();

        // bubble sort
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {

                // use the int to compare
                if (charArray[i] > charArray[j]) {
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        return new String(charArray);
    }
}
