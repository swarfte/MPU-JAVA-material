package chapter12;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Count characters, words , and lines in a file
 */
public class Ch12Ex13 {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        int characters = 0;
        int words = 0;
        int lines = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines++;
                String line = scanner.nextLine();
                characters += line.length();
                words += line.split(" ").length;
            }
        }
        System.out.println("Characters: " + characters);
        System.out.println("Words: " + words);
        System.out.println("Lines: " + lines);
    }
}
