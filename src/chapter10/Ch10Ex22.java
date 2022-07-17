package chapter10;

/**
 * @author swarfte
 * @title Implement the String class
 */
public class Ch10Ex22 {
    public static void main(String[] args) {

    }
}


class MyString1 {
    private char[] string;

    public MyString1(char[] chars) {
        this.string = chars;
    }

    public char charAt(int index) {
        return string[index];
    }

    public int length() {
        return string.length;
    }

    public MyString1 substring(int beginIndex, int endIndex) {
        char[] newString = new char[endIndex - beginIndex];
        for (int i = beginIndex; i < endIndex; i++) {
            newString[i - beginIndex] = string[i];
        }
        return new MyString1(newString);
    }

    public MyString1 toLowerCase() {
        char[] newString = new char[string.length];
        for (int i = 0; i < string.length; i++) {
            newString[i] = Character.toLowerCase(string[i]);
        }
        return new MyString1(newString);
    }

    public boolean equals(MyString1 s) {

        // check length
        if (s.length() != this.length()) {
            return false;
        }

        // check each character
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != this.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        return new MyString1(String.valueOf(i).toCharArray());
    }
}