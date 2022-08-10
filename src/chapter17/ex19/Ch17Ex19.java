package chapter17.ex19;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author swarfte
 * @title View hex
 */
public class Ch17Ex19 {
    public static void main(String[] args) throws Exception {
        String relativePath = "src/chapter17/ex19/";
        String targetFileName = relativePath + args[0];
        File file = new File(targetFileName);
        try (DataInputStream stream = new DataInputStream(new FileInputStream(file))) {
            int hex;
            try {
                while ((hex = stream.readInt()) != -1) {
                    System.out.println(Integer.toHexString(hex));
                }
            } catch (IOException e) {
                System.out.println("Read all hex");
            }
        }
    }
}
