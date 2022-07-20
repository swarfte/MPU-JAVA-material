package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Remove package statement
 */
public class Ch12Ex20 {
    public static void main(String[] args) throws Exception {
        // haven't check this method is work

        File dir = new File(args[0]);
        String prefix = "\\chapter";

        for (int i = 1; i <= 34; i++) {
            File file = new File(dir + prefix + i);
            File[] matchingFiles = file.listFiles((dir1, name) -> name.endsWith(".java"));
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
                    out.print("");

                    // skip the first line (package chapterI)
                    for (int k = 1; k < lines.size(); k++) {
                        out.println(lines.get(k));
                    }
                    out.close();
                }
            }
        }
    }
}
