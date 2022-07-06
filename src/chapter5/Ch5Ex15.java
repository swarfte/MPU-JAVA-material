package chapter5;

/**
 * @author swarfte
 * @title Display the ASCII character table
 */
public class Ch5Ex15 {
    public static void main(String[] args) {
        int count = 0;
        StringBuilder table = new StringBuilder();
        for (int i = 33; i < 127; i++) {
            table.append((char) (i)).append(' ');
            count++;
            if (count == 10) {
                table.append('\n');
                count = 0;
            }
        }
        System.out.println(table.toString());
    }
}
