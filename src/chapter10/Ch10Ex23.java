package chapter10;

/**
 * @author swarfte
 * @title Implement the String class
 */
public class Ch10Ex23 {
    public static void main(String[] args) {

    }
}

class MyString2 {
    private String string;

    public MyString2(String s) {
        this.string = s;
    }

    public int compare(String s) {
        int length = Math.min(this.string.length(), s.length());
        for (int i = 0; i < length; i++) {
            if (this.string.charAt(i) != s.charAt(i)) {
                return this.string.charAt(i) - s.charAt(i);
            }
        }
        return 0;
    }

    public MyString2 substring(int begin) {
        int length = this.string.length() - begin;
        String temp = "";
        for (int i = begin; i < length; i++) {
            temp += this.string.charAt(i);
        }
        return new MyString2(temp);
    }

    public MyString2 toUpperCase() {
        String temp = "";
        for (int i = 0; i < this.string.length(); i++) {
            if (this.string.charAt(i) >= 'a' && this.string.charAt(i) <= 'z') {
                temp += (char) (this.string.charAt(i) - 32);
            } else {
                temp += this.string.charAt(i);
            }
        }
        return new MyString2(temp);
    }

    public char[] toChars() {
        char[] temp = new char[this.string.length()];
        for (int i = 0; i < this.string.length(); i++) {
            temp[i] = this.string.charAt(i);
        }
        return temp;
    }

    public static MyString2 valueOf(int i) {
        char temp = (char) (((int) '0') + i);
        String s = "" + temp;
        return new MyString2(s);
    }


}