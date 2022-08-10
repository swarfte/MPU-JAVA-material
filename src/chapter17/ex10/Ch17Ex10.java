package chapter17.ex10;

import java.io.*;

/**
 * @author swarfte
 * @title Split files
 */
public class Ch17Ex10 {
    public static void main(String[] args) throws IOException {
        String relativePath = "src/chapter17/ex10/";
        String fileName = relativePath + args[0];
        int numberOfPieces = Integer.parseInt(args[1]);
        splitFile(fileName, numberOfPieces);
    }

    public static void splitFile(String fileName, int numberOfPieces) throws IOException {
        File file = new File(fileName);
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            int size = (int) file.length();
            int pieceSize = size / numberOfPieces;
            int remainder = size % numberOfPieces;
            int count = 0;
            for (int i = 1; i < numberOfPieces + 1; i++) {
                int bytesRead = 0;
                byte[] buffer = new byte[pieceSize];
                String pieceName = fileName + "." + i;
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pieceName))) {
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                count++;
            }
            if (remainder != 0) {
                int bytesRead = 0;
                byte[] buffer = new byte[remainder];
                String pieceName = fileName + "." + count;
                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pieceName))) {
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
    }
}
