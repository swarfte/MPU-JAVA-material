package chapter12;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Occurrences of each letter
 */
public class Ch12Ex30 {
    public static void main(String[] args) throws Exception {
        String dirName = System.getProperty("user.dir");
        dirName += "\\src\\chapter12\\";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String fileName = scanner.nextLine();
        dirName += fileName;
        int[] countList = new int[26];
        File files = new File(dirName);
        try (Scanner in = new Scanner(files)) {
            while (in.hasNextLine()) {
                String line = in.nextLine().toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    if (ch >= 'a' && ch <= 'z') {
                        countList[ch - 'a']++;
                    }
                }
            }
        }
        for (int i = 0; i < countList.length; i++) {
            System.out.println("Number of " + (char) (i + 'A') + "s: " + countList[i]);
        }
    }
}
