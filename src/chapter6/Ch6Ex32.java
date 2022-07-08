package chapter6;

/**
 * @author swarfte
 * @title Game: chance of winning at craps
 */
public class Ch6Ex32 {
    public static void main(String[] args) {
        int count = 0;
        int win = 0;
        while (count < 15000) {
            if (crapsGame()) {
                win++;
            }
            count++;
        }
        System.out.println("The number of winning games is : " + win);
    }

    public static boolean crapsGame() {
        int oldNumber = -1;
        while (true) {
            if (oldNumber < 0) {
                int newNumber = getNumber();
                getResult(newNumber);
                if (isWin(newNumber)) {
                    return true;
                } else if (isLose(newNumber)) {
                    return false;
                }
                oldNumber = newNumber;
            } else {
                int newNumber = getNumber();
                if (newNumber == oldNumber) {
                    System.out.println("You win");
                    return true;
                } else if (newNumber == 7) {
                    System.out.println("You lose");
                    return false;
                }
                getResult(newNumber);
                if (isWin(newNumber)) {
                    return true;
                } else if (isLose(newNumber)) {
                    return false;
                }
                oldNumber = newNumber;
            }
        }
    }

    public static int getNumber() {
        int number1 = (int) (Math.random() * 6) + 1;
        int number2 = (int) (Math.random() * 6) + 1;
        System.out.println("You rolled " + number1 + " + " + number2 + " = " + (number1 + number2));
        return number1 + number2;
    }

    public static void getResult(int number) {
        if (number == 7 || number == 11) {
            System.out.println("You win");
        } else if (number == 2 || number == 3 || number == 12) {
            System.out.println("You lose");
        } else {
            System.out.println("point is " + number);
        }
    }

    public static boolean isAgain(int number) {
        return number != 7 && number != 11 && number != 2 && number != 3 && number != 12;
    }

    public static boolean isWin(int number) {
        return number == 7 || number == 11;
    }

    public static boolean isLose(int number) {
        return number == 2 || number == 3 || number == 12;
    }

}
