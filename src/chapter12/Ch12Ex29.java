package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author swarfte
 */
public class Ch12Ex29 {
    public static void main(String[] args) throws Exception {
        String dirName = args[0];
        File file = new File(dirName);
        File[] matchingFiles = file.listFiles((dir, name) -> name.endsWith(".txt"));
        assert matchingFiles != null;
        for (File matchingFile : matchingFiles) {
            String fileName = (matchingFile.getName());
            if (fileName.contains("Exercise")) {
                if (fileName.matches("Exercise\\d_\\d.txt")) {
                    File newFile = new File(dirName + "\\" + addZero(fileName));
                    ArrayList<String> lines = new ArrayList<>();
                    try (Scanner in = new Scanner(matchingFile)) {
                        while (in.hasNextLine()) {
                            lines.add(in.nextLine());
                        }
                    }
                    try (PrintWriter out = new PrintWriter(newFile)) {
                        for (String line : lines) {
                            out.println(line);
                        }
                    }
                    boolean check = matchingFile.delete();
                }
            }
        }
        System.out.println(Arrays.toString(matchingFiles));
    }

    public static String addZero(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '_') {
                newStr = str.substring(0, i - 1) + str.charAt(i - 1) + "_" + "0" + str.substring(i + 1);
            }
        }
        return newStr;
    }
}
