package chapter17.ex2;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author swarfte
 * @title Create a binary data file
 */
public class Ch17Ex2 {
    public static void main(String[] args) throws Exception {
        File file = new File("src/chapter17/ex2/Exercise17_02.dat");
        if (file.exists()) {
            write(file);
        } else {
            if (file.createNewFile()) {
                write(file);
            }
        }
    }

    public static void write(File file) throws IOException {
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        for (int i = 0; i < 150; i++) {
            int number = (int) (Math.random() * 150);
            writer.write(number);
        }
        writer.close();
    }
}
