package chapter17.ex5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author swarfte
 * @title Store objects and arrays in a file
 */
public class Ch17Ex5 {
    public static void main(String[] args) throws Exception {
        String fileName = "src/chapter17/ex5/Exercise17_05.dat";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        int[] array = {1, 2, 3, 4, 5, 6};
        out.writeObject(array);
        out.writeObject(new java.util.Date());
        out.writeDouble(10.5);
        out.close();
    }
}
