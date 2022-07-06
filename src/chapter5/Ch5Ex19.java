package chapter5;

/**
 * @author swarfte
 * @title Display number in a pyramid pattern
 */
public class Ch5Ex19 {
    public static void main(String[] args) {
        int line = 8;
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < line; i++) {
            for (int y = 0; y < line - (i + 1); y++) {
                row.append("      ");
            }
            row.append(getPyramid(i));
            for (int y = 0; y < line - (i + 1); y++) {
                row.append("      ");
            }
            row.append("\n");
        }
        System.out.println(row);
    }

    public static String getPyramid(int index) {
        return getPyramid(index, 0, true, "");
    }

    public static String getPyramid(int size, int currentNumber, boolean increased, String output) {
        if (size > 0) {

            // each turn add one number
            output += Math.pow(3, currentNumber) + "  ";

            // the last one digit
            if (currentNumber == 0 && !increased) {
                return output;
            }

            //when the number is increasing
            if (currentNumber < size && increased) {
                return getPyramid(size, currentNumber + 1, increased, output);

                // the middle digit
            } else if (currentNumber == size && increased) {
                return getPyramid(size, currentNumber - 1, !increased, output);

                // when the number is decreasing
            } else if (currentNumber < size && !increased) {
                return getPyramid(size, currentNumber - 1, increased, output);
            }
            return "";
        } else {
            return "" + Math.pow(3, currentNumber);
        }
    }
}
