package chapter6;

/**
 * @author swarfte
 * @title Generate random characters
 */
public class Ch6Ex38 {
    public static void main(String[] args) {
        int size = 200;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++) {
            sb.append(getRandomUpperCaseLetter()).append(" ");
            count++;
            if (count == 10) {
                count = 0;
                sb.append("\n");
            }
        }
        count = 0;
        sb.append("\n");
        for (int i = 1; i <= size; i++) {
            sb.append(getRandomDigitCharacter()).append(" ");
            count++;
            if (count == 10) {
                count = 0;
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static char getRandomLowerCaseLetter() {
        return getRandomCharacter('a', 'z');
    }

    public static char getRandomUpperCaseLetter() {
        return getRandomCharacter('A', 'Z');
    }

    public static char getRandomDigitCharacter() {
        return getRandomCharacter('0', '9');
    }

    public static char getRandomCharacter() {
        return getRandomCharacter('\u0000', '\uFFFF');
    }

}
