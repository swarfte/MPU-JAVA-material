package chapter12;

/**
 * @author swarfte
 * @title NumberFormatException
 */
public class Ch12Ex1 {
    public static void main(String[] args) throws Exception {
        int i = 0;
        String symbol = "";
        int j = 0;

        try {
            i = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Wrong Input :" + args[0]);
            System.exit(0);
        }

        try {
            j = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.out.println("Wrong Input :" + args[2]);
            System.exit(0);
        }

        try {
            symbol = args[1];
        } catch (Exception e) {
            System.out.println("Wrong Input :" + args[1]);
            System.exit(0);
        }

        System.out.println(i + " " + symbol + " " + j + " = " + switch (symbol) {
            case "+" -> i + j;
            case "-" -> i - j;
            case "*" -> i * j;
            case "/" -> i / j;
            default -> throw new IllegalArgumentException("Wrong symbol : " + symbol);
        });
    }
}
