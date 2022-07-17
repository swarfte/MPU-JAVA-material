package chapter10;

/**
 * @author swarfte
 * @title New string split method
 */
public class Ch10Ex25 {
    public static void main(String[] args) {

    }


    public static String[] split(String s, String regex) {
        // the method return contains the regex
        String[] temp = {"", ""};
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + regex.length());
            if (substring.equals(regex)) {
                temp[0] += substring;
                temp[1] += regex;
            }
        }

        return temp;
    }
}
