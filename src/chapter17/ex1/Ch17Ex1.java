package chapter17.ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author swarfte
 * @title Create a text file
 */
public class Ch17Ex1 {
    public static void main(String[] args) throws Exception {
        File file = new File("src/chapter17/ex1/Exercise17_01.txt");
        if (file.exists()) {
            write(file);
        } else {
            if (file.createNewFile()) {
                write(file);
            }
        }
    }

    public static void write(File file) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (int i = 0; i < 150; i++) {
            int number = (int) (Math.random() * 150);
            writer.print(number);
            writer.print(" ");
        }
        writer.close();
    }
}
