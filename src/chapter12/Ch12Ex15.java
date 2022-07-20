package chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Writing in a sorted file
 */
public class Ch12Ex15 {
    public static void main(String[] args) throws Exception {
        File file = new File(args[1]);
        System.out.println(writeInFile(args[0], file));
    }

    public static int writeInFile(String name, File file) throws FileNotFoundException {
        int index = -1;
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).compareTo(name) > 0) {
                index = i;
                lines.add(i, name);
                break;
            }
        }

        if (index == -1) {
            lines.add(name);
            index = lines.size() - 1;
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
            for (String line : lines) {
                writer.println(line);
            }
        }

        return index;
    }
}
