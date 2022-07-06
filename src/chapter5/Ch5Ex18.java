package chapter5;

/**
 * @author swarfte
 * @title Display four patterns using loops
 */
public class Ch5Ex18 {
    public static void main(String[] args) {
        System.out.println(patternA(6));
        System.out.println(patternB(6));
        System.out.println(patternC(6));
        System.out.println(patternD(6));
    }

    public static String patternA(int size) {
        StringBuilder output = new StringBuilder();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x <= y; x++) {
                output.append("* ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public static String patternB(int size) {
        StringBuilder output = new StringBuilder();
        for (int y = size; y > 0; y--) {
            for (int x = y; x > 0; x--) {
                output.append("* ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public static String patternC(int size) {
        StringBuilder output = new StringBuilder();
        for (int y = size; y > 0; y--) {
            for (int x = y - 1; x > 0; x--) {
                output.append("  ");
            }
            for (int x = size - y + 1; x > 0; x--) {
                output.append("* ");
            }
            output.append("\n");
        }
        return output.toString();
    }

    public static String patternD(int size) {
        StringBuilder output = new StringBuilder();
        for (int y = size; y > 0; y--) {
            for (int x = size - y; x > 0; x--) {
                output.append("  ");
            }
            for (int x = y; x > 0; x--) {
                output.append("* ");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
