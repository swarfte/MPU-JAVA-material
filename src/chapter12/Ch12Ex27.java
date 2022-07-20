package chapter12;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Replace words
 */
public class Ch12Ex27 {
    public static void main(String[] args) throws Exception {
        String dirName = args[0];
        File file = new File(dirName);
        File[] matchingFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));
        assert matchingFiles != null;
        for (File matchingFile : matchingFiles) {
            ArrayList<String> lines = new ArrayList<>();
            try (Scanner in = new Scanner(matchingFile)) {
                while (in.hasNextLine()) {
                    lines.add(in.nextLine());
                }
            }
            try (PrintWriter out = new PrintWriter(matchingFile)) {
                for (String line : lines) {
                    if (line.matches("Exercise\\d_\\d")) {
                        out.println(addZero(line));
                    } else {
                        out.println(line);
                    }
                }
            }
        }
    }

    public static String addZero(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                newStr = str.substring(0, i - 1) + "0" + str.charAt(i - 1) + "_" + "0" + str.substring(i + 1);
            }
        }
        return newStr;
    }
}
