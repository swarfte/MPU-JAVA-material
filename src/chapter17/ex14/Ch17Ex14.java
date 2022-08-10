package chapter17.ex14;

import java.io.*;

/**
 * @author swarfte
 * @title Encrypt files
 */
public class Ch17Ex14 {
    public static void main(String[] args) throws Exception {
        String relativePath = "src/chapter17/ex14/";
        String sourceFileName = relativePath + args[0];
        String targetFileName = relativePath + args[1];
        encryptFiles(sourceFileName, targetFileName, 10);

    }

    public static void encryptFiles(String sourceFileName, String targetFileName, int encryptBytes) throws IOException {
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
                    out.write(buffer, 0, bytesRead + encryptBytes);
                }
            }
        }
    }
}
