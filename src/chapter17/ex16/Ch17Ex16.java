package chapter17.ex16;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author swarfte
 * @title Frequency of characters
 */
public class Ch17Ex16 {
    public static void main(String[] args) throws Exception {
        String relativePath = "src/chapter17/ex16/";
        String targetFileName = relativePath + args[0];
        frequencyOfCharacters(targetFileName);
    }

    public static void frequencyOfCharacters(String targetFileName) throws IOException {
        File targetFile = new File(targetFileName);
        int[] count = new int[128];
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(targetFile))) {
            int c;
            while ((c = inputStream.read()) != -1) {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println((char) i + ": " + count[i]);
        }
    }
}
