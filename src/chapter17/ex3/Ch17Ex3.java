package chapter17.ex3;

import java.io.*;

/**
 * @author swarfte
 * @title Sum all floating points in a binary data file
 */
public class Ch17Ex3 {
    public static void main(String[] args) throws Exception {
        File file = new File("src/chapter17/ex3/Exercise17_03.dat");
        if (file.exists()) {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            double sum = 0;
            while (in.available() > 0) {
                sum += in.readDouble();
            }
            System.out.println("Sum of all floating points in the file: " + sum);
            in.close();
        } else {
            if (file.createNewFile()) {
                DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
                for (int i = 0; i < 10; i++) {
                    double number = Math.random() * 100;
                    out.writeDouble(number);
                }
                out.close();
            }
        }
    }
}
