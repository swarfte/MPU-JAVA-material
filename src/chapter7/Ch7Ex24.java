package chapter7;

/**
 * @author swarfte
 * @title Simulation: coupon collector's problem
 */
public class Ch7Ex24 {
    public static void main(String[] args) {
        String[][] deck = createDeck();
        boolean[][] count = new boolean[4][13];
        int run = 4;

        for (int i = 0; i < run; i++) {
            int suit = (int) (Math.random() * deck.length);
            int card = (int) (Math.random() * deck[0].length);
            count[suit][card] = true;
            System.out.println(deck[suit][card]);
        }
        int mix = count[0].length;
        for (int i = 0; i < count.length; i++) {
            int numberOfPicks = 0;
            for (int j = 0; j < count[i].length; j++) {
                if (!count[i][j]) {
                    numberOfPicks++;
                }
            }
            if (numberOfPicks < mix) {
                mix = numberOfPicks;
            }
        }
        System.out.println("Number of picks : " + mix);
    }

    public static String[][] createDeck() {
        String[][] deck = new String[4][13];
        String suit = "";
        for (int i = 0; i < deck.length; i++) {
            if (i == 0) {
                suit = "Spades";
            } else if (i == 1) {
                suit = "Club";
            } else if (i == 2) {
                suit = "Diamond";
            } else {
                suit = "Heart";
            }
            for (int j = 0; j < deck[i].length; j++) {
                deck[i][j] = String.format("%d of %s", j + 1, suit);
            }
        }
        return deck;
    }
}
