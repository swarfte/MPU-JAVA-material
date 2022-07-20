package chapter12;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Add package statement
 */
public class Ch12Ex18 {
    public static void main(String[] args) throws Exception {
        // haven't check this method is work

        String dirName = args[0];
        String prefix = "\\chapter";

        for (int i = 1; i <= 34; i++) {
            File file = new File(dirName + prefix + i);
            File[] matchingFiles = file.listFiles((dir, name) -> name.endsWith(".java"));
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
                    out.println("package chapter" + i);
                    for (String line : lines) {
                        out.println(line);
                    }
                    out.close();
                }
            }
        }
    }
}
