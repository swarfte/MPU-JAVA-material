package chapter17.ex15;

import java.io.*;

/**
 * @author swarfte
 * @title Decrypt files
 */
public class Ch17Ex15 {
    public static void main(String[] args) throws Exception {
        String relativePath = "src/chapter17/ex15/";
        String sourceFileName = relativePath + args[0];
        String targetFileName = relativePath + args[1];
        decryptFiles(sourceFileName, targetFileName, 10);
    }

    public static void decryptFiles(String sourceFileName, String targetFileName, int decryptBytes) throws IOException {
        File sourceFile = new File(sourceFileName);
        if (!sourceFile.exists()) {
            sourceFile.createNewFile();
        }
        File targetFile = new File(targetFileName);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourceFile))) {
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile))) {
                int bytesRead = 0;
                byte[] buffer = new byte[1024];
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead - decryptBytes);
                }
            }
        }
    }
}
