package chapter12;

/**
 * @author swarfte
 * @title HexFormatException
 */
public class Ch12Ex8 {
    public static void main(String[] args) throws Exception {
        String hex = "1234G";
        int dec = hexToDecimal(hex);
        System.out.println(dec);
    }

    public static int hexToDecimal(String hex) throws HexFormatException {
        if (hex.length() == 0) {
            throw new HexFormatException("Empty string");
        }
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) throws HexFormatException {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            throw new HexFormatException("Invalid hex character");
        }
    }
}

class HexFormatException extends Exception {
    public HexFormatException(String message) {
        super(message);
    }
}