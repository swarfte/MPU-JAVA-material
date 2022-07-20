package chapter12;

/**
 * @author swarfte
 * @title Checked Exception
 */
public class Ch12Ex7 {
    public static void main(String[] args) throws Exception {

    }
}


class NullDenominatorException extends Exception {
    public NullDenominatorException(String message) {
        super(message);
    }
}
