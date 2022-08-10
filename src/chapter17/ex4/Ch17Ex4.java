package chapter17.ex4;

import java.io.*;

/**
 * @author swarfte
 * @title Convert a text file into UTF
 */
public class Ch17Ex4 {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java Ch17Ex4 <text file> <binary file>");
            System.exit(1);
        }
        String relativePath = "src/chapter17/ex4/";
        String textFile = relativePath + args[0];
        String binaryFile = relativePath + args[1];
        File text = new File(textFile);
        if (!text.exists()) {
            if (text.createNewFile()) {
                DataOutputStream out = new DataOutputStream(new FileOutputStream(text));
                out.writeUTF("Welcome to the world of Java");
            }
        }
        File binary = new File(binaryFile);
        if (!binary.exists()) {
            binary.createNewFile();
        }
        DataInputStream in = new DataInputStream(new FileInputStream(text));
        DataOutputStream out = new DataOutputStream(new FileOutputStream(binary));
        try {
            while (true) {
                out.writeUTF(in.readUTF());
            }
        } catch (IOException e) {
            System.out.println("All data were read");
        } finally {
            in.close();
            out.close();
        }

    }
}
