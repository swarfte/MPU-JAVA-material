package chapter12;

/**
 * @author swarfte
 * @title NumberFormatException
 */
public class Ch12Ex6 {
    public static void main(String[] args) throws Exception {
        String hex = "123G";
        int dec = hexToDecimal(hex);
        System.out.println(dec);
    }

    public static int hexToDecimal(String hex) throws NumberFormatException {
        if (hex.length() == 0) {
            throw new NumberFormatException("Empty string");
        }
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) throws NumberFormatException {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            throw new NumberFormatException("Invalid hex character");
        }
    }
}
