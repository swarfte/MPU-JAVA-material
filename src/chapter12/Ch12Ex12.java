package chapter12;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author swarfte
 * @title Reformat Java source code
 */
public class Ch12Ex12 {
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        ArrayList<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("{")) {
                    String temp = data.get(data.size() - 1);
                    data.remove(data.size() - 1);
                    temp += line;
                    data.add(temp);
                } else {
                    data.add(line);
                }
            }
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print("");
            for (String line : data) {
                writer.println(line);
            }
        }
    }
}
