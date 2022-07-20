package chapter12;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * @author swarfte
 * @title Remove text
 */
public class Ch12Ex11 {
    public static void main(String[] args) throws Exception {
        String keyWord = args[0];
        File file = new File(args[1]);
        Scanner scanner = new Scanner(file);
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            if (temp.contains(keyWord)) {
                lines.add(temp.replace(keyWord, ""));
            } else {
                lines.add(temp);
            }
        }
        scanner.close();
        PrintWriter writer = new PrintWriter(args[1]);
        writer.print("");
        for (String line : lines) {
            writer.println(line);
        }
        writer.close();
    }
}
