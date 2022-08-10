package chapter17.ex18;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author swarfte
 * @title View bits
 */
public class Ch17Ex18 {
    public static void main(String[] args) throws Exception {
        String relativePath = "src/chapter17/ex18/";
        String targetFileName = relativePath + args[0];
        File file = new File(targetFileName);
        try (DataInputStream stream = new DataInputStream(new FileInputStream(file))) {
            int bit;
            try {
                while ((bit = stream.readInt()) != -1) {
                    System.out.println(getBits(bit));
                }
            } catch (IOException e) {
                System.out.println("Read all bits");
            }

        }

    }

    public static String getBits(int value) {
        return Integer.toBinaryString(value);
    }
}
