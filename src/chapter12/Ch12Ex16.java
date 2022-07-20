package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author swarfte
 * @title Replace text
 */
public class Ch12Ex16 {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        String oldString = args[1];
        String newString = args[2];
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(oldString)) {
                lines.set(i, lines.get(i).replace(oldString, newString));
            }
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
            for (String line : lines) {
                writer.println(line);
            }
        }
    }
}
