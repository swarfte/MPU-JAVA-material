package chapter10;

/**
 * @author swarfte
 * @title Implement the StringBuilder class
 */
public class Ch10Ex27 {
    public static void main(String[] args) {

    }
}

class MyStringBuilder1 {
    private String s;

    public MyStringBuilder1(String s) {
        this.s = s;
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        this.s += s.s;
        return this;
    }

    public MyStringBuilder1 append(int i) {
        this.s += i;
        return this;
    }

    public int length() {
        return this.s.length();
    }

    public char charAt(int i) {
        for (int j = 0; j < this.s.length(); j++) {
            if (j == i) {
                return this.s.charAt(j);
            }
        }
        return ' ';
    }

    public MyStringBuilder1 toLowerCase() {
        String temp = "";
        for (int i = 0; i < this.s.length(); i++) {
            if (this.s.charAt(i) >= 'A' && this.s.charAt(i) <= 'Z') {
                temp += (char) (this.s.charAt(i) + 32);
            } else {
                temp += this.s.charAt(i);
            }
        }
        this.s = temp;
        return this;
    }

    public MyStringBuilder1 substring(int begin, int end) {
        String temp = "";
        for (int i = begin; i < end; i++) {
            temp += this.s.charAt(i);
        }
        this.s = temp;
        return this;
    }

    public String toString() {
        return this.s;
    }
}
