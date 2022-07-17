package chapter10;

/**
 * @author swarfte
 * @title Implement the StingBuilder class
 */
public class Ch10Ex28 {
    public static void main(String[] args) {

    }
}

class MyStringBuilder2 {
    private String s;

    public MyStringBuilder2(char[] chars) {
        s = new String(chars);
    }

    public MyStringBuilder2(String s) {
        this.s = s;
    }

    public MyStringBuilder2 insert(int offset, MyStringBuilder2 s) {
        String first = this.s.substring(0, offset);
        String temp = s.s;
        String second = this.s.substring(offset);
        this.s = first + temp + second;
        return this;
    }

    public MyStringBuilder2 reverse() {
        String temp = "";
        for (int i = this.s.length() - 1; i >= 0; i--) {
            temp += this.s.charAt(i);
        }
        s = temp;
        return this;
    }

    public MyStringBuilder2 substring(int begin) {
        String temp = "";
        for (int i = begin; i < this.s.length(); i++) {
            temp += this.s.charAt(i);
        }
        return new MyStringBuilder2(temp);
    }

    public MyStringBuilder2 toUpperCase() {
        String temp = "";
        for (int i = 0; i < this.s.length(); i++) {
            temp += Character.toUpperCase(this.s.charAt(i));
        }
        s = temp;
        return this;
    }
}
