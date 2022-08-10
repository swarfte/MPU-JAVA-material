package chapter17.ex12;

import java.io.*;

/**
 * @author swarfte
 * @title Combine files
 */
public class Ch17Ex12 {
    public static void main(String[] args) throws IOException {
        String relativePath = "src/chapter17/ex12/";
        String[] sourceFile = new String[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            sourceFile[i] = relativePath + args[i];
        }
        String targetFile = relativePath + args[args.length - 1];
        combineFiles(sourceFile, targetFile);
    }

    public static void combineFiles(String[] sourceFilesNames, String targetFilesNames) throws IOException {
        File[] sourceFiles = new File[sourceFilesNames.length];
        File targetFile = new File(targetFilesNames);

        for (int i = 0; i < sourceFilesNames.length; i++) {
            sourceFiles[i] = new File(sourceFilesNames[i]);
        }

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile));
        for (int i = 0; i < sourceFiles.length; i++) {
            try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(sourceFiles[i]))) {
                int bytesRead = 0;
                while ((bytesRead = inputStream.read()) != -1) {
                    outputStream.write(bytesRead);
                }
            }
        }
        outputStream.close();
    }
}
