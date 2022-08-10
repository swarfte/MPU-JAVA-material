package chapter17.ex8;

import java.io.*;
import java.util.Scanner;

/**
 * @author swarfte
 * @title Update count
 */
public class Ch17Ex8 {
    public static void main(String[] args) throws Exception {
        String countFileName = "src/chapter17/ex8/Exercise17_08.dat";
        String executedFileName = "src/chapter17/ex8/Exercise17_08.txt";
        File countFile = new File(countFileName);
        File executedFile = new File(executedFileName);
        if (!countFile.exists()) {
            countFile.createNewFile();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(countFile));
            out.writeInt(0);
            out.close();
        }
        if (!executedFile.exists()) {
            executedFile.createNewFile();
            try (PrintWriter out = new PrintWriter(executedFile)) {
                out.println("Test");
            }
        }
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(countFile));
        int count;
        try {
            count = in.readInt();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(countFile));
            out.writeInt(count + 1);
            System.out.println("Count: " + count);
            out.close();
        } catch (EOFException e) {

        } finally {
            in.close();
        }

        try (Scanner read = new Scanner(executedFile)) {
            try {
                String executed = read.nextLine();
                System.out.println(executed);
            } catch (Exception e) {

            }
        }


    }
}
