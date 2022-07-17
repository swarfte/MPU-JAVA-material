package chapter10;

/**
 * @author swarfte
 * @title Implement the Character class
 */
public class Ch10Ex24 {
    public static void main(String[] args) {

    }
}

class MyCharacter {
    private char character;

    public MyCharacter(char c) {
        this.character = c;
    }

    public int compare(char c) {
        if (this.character == c) {
            return 0;
        } else if (this.character > c) {
            return 1;
        } else {
            return -1;
        }
    }

    public MyCharacter toUpperCase() {
        if (this.character >= 'a' && this.character <= 'z') {
            return new MyCharacter((char) (this.character - 32));
        } else {
            return this;
        }
    }

    public char[] toChars() {
        char[] temp = new char[1];
        temp[0] = this.character;
        return temp;
    }

    public static MyCharacter valueOf(int i) {
        return new MyCharacter((char) (((int) '0') + i));
    }
}
