package chapter17.ex17;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author swarfte
 * @title BitOutputStream
 */
public class Ch17Ex17 {
    public static void main(String[] args) throws Exception {
        String relativePath = "src/chapter17/ex17/";
        String targetFileName = relativePath + args[0];
        BitOutputStream stream = new BitOutputStream(new File(targetFileName));
        stream.writeBit("1");
        stream.writeBit("0101");
        stream.close();
    }
}

class BitOutputStream {
    DataOutputStream outputStream;
    StringBuilder bitString = new StringBuilder();


    public BitOutputStream(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        outputStream = new DataOutputStream(new FileOutputStream(file));
    }

    public void writeBit(char bit) throws IOException {
        writeBit(bit + "");
    }

    public void writeBit(String bit) throws IOException {
        if (bitString.length() + bit.length() <= 8) {
            bitString.append(bit);
        } else {
            int index = 0;
            while (index < bit.length()) {
                if (bitString.length() == 8) {
                    flash();
                }
                bitString.append(bit.charAt(index));
                index++;
            }
        }
    }

    public void close() throws IOException {
        flash();
        outputStream.close();
    }

    private void flash() throws IOException {
        if (bitString.length() != 8) {
            int zeroCount = 8 - bitString.length();
            for (int i = 0; i < zeroCount; i++) {
                bitString.insert(0, "0");
            }
        }
        outputStream.writeUTF(bitString.toString());
        bitString = new StringBuilder();
    }
}
