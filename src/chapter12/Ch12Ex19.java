package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ch12Ex19 {
    public static void main(String[] args) throws Exception {
        File books = new File(args[0]);
        File authors = new File(args[1]);
        String authorName;
        String bookName;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter author name: ");
            authorName = scanner.nextLine();
            System.out.print("Enter book name: ");
            bookName = scanner.nextLine();
        }
        ArrayList<String> bookLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(authors)) {
            while (scanner.hasNextLine()) {
                bookLines.add(scanner.nextLine());
            }
        }

        ArrayList<String> authorLines = new ArrayList<>();
        try (Scanner scanner = new Scanner(books)) {
            while (scanner.hasNextLine()) {
                authorLines.add(scanner.nextLine());
            }
        }

        for (int i = 0; i < bookLines.size(); i++) {
            if (bookLines.get(i).contains(bookName)) {
                bookLines.remove(i);
                bookLines.add(i, bookName + " " + authorName);
                break;
            }
        }

        try (PrintWriter writer = new PrintWriter(books)) {
            writer.print("");
            for (String line : bookLines) {
                writer.println(line);
            }
        }

        for (int i = 0; i < authorLines.size(); i++) {
            if (authorLines.get(i).contains(authorName)) {
                authorLines.remove(i);
                authorLines.add(i, authorName + " " + bookName);
                break;
            }
        }

        try (PrintWriter writer = new PrintWriter(authors)) {
            writer.print("");
            for (String line : authorLines) {
                writer.println(line);
            }
        }
    }

}
