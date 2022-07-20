package chapter12;

import java.io.File;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Using two files
 */
public class Ch12Ex21 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of author: ");
        String author = scanner.nextLine();
        File books = new File(args[0]);
        try (Scanner reader = new Scanner(books)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.contains(author)) {
                    System.out.println(line);
                    break;
                }
            }
        }
    }
}
