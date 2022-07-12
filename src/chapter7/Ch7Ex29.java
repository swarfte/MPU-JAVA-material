package chapter7;

/**
 * @author swarfte
 * @title Game : dice
 */
public class Ch7Ex29 {
    public static void main(String[] args) {
        for (int firstDice = 1; firstDice <= 6; firstDice++) {
            for (int secondDice = 1; secondDice <= 6; secondDice++) {
                for (int thirdDice = 1; thirdDice <= 6; thirdDice++) {
                    if (firstDice + secondDice + thirdDice == 9) {
                        System.out.println("(" + firstDice + "," + secondDice + "," + thirdDice + ")");
                    }
                }
            }
        }
    }
}
