package chapter12;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Replace text
 */
public class Ch12Ex22 {
    public static void main(String[] args) throws Exception {
        // haven't check this method is work

        File dir = new File(args[0]);
        String oldString = args[1];
        String newString = args[2];

        File[] matchingFiles = dir.listFiles((dir1, name) -> name.endsWith(".java"));

        assert matchingFiles != null;
        if (matchingFiles.length > 0) {
            for (File matchingFile : matchingFiles) {
                Scanner in = new Scanner(matchingFile);
                ArrayList<String> lines = new ArrayList<>();
                while (in.hasNextLine()) {
                    lines.add(in.nextLine());
                }
                in.close();

                PrintWriter out = new PrintWriter(matchingFile);
                for (String line : lines) {
                    out.println(line.replaceAll(oldString, newString));
                }
                out.close();
            }
        }
    }
}
