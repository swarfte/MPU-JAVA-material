package chapter12;

/**
 * @author swarfte
 * @title BinaryFormatException
 */
public class Ch12Ex9 {
    public static void main(String[] args) throws Exception {
        String binary = "111111103";
        int dec = binaryToDecimal(binary);
        System.out.println(dec);
    }

    public static int binaryToDecimal(String binary) throws BinaryFormatException {
        if (binary.length() == 0) {
            throw new BinaryFormatException("Empty string");
        }
        int decimalValue = 0;
        for (int i = 0; i < binary.length(); i++) {
            char binaryChar = binary.charAt(i);
            decimalValue = decimalValue * 2 + binaryCharToDecimal(binaryChar);
        }
        return decimalValue;
    }

    public static int binaryCharToDecimal(char ch) throws BinaryFormatException {
        if (ch == '0') {
            return 0;
        } else if (ch == '1') {
            return 1;
        } else {
            throw new BinaryFormatException("Invalid binary character");
        }
    }
}

class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}