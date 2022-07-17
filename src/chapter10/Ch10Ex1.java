package chapter10;

/**
 * @author swarfte
 * @title The Time class
 */
public class Ch10Ex1 {
    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(5, 23, 55);
        Time time3 = new Time(555550000);
        System.out.println("Hour: " + time1.getHour() + " minutes: " + time1.getMinute() + " seconds: " + time1.getSecond());
        System.out.println("Hour: " + time2.getHour() + " minutes: " + time2.getMinute() + " seconds: " + time2.getSecond());
        System.out.println("Hour: " + time3.getHour() + " minutes: " + time3.getMinute() + " seconds: " + time3.getSecond());
    }
}

/**
 * UML diagram
 * <p>
 * Time
 * <p>
 * - second: int
 * <p>
 * - minute: int
 * <p>
 * - hour: int
 * <p>
 * + Time()
 * <p>
 * + Time(elapsedTime: long)
 * <p>
 * + Time(hour: int, minute: int, second: int)
 * <p>
 * + getHour(): int
 * <p>
 * + getMinute(): int
 * <p>
 * + getSecond(): int
 * <p>
 * + setHour(hour: int): void
 * <p>
 * + setMinute(minute: int): void
 * <p>
 * + setSecond(second: int): void
 * <p>
 * + setTime(elapseTime : long): void
 */

class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        long elapsedTime = System.currentTimeMillis();
        this.hour = (int) (elapsedTime / 1000 / 60 / 60) % 24;
        this.minute = (int) (elapsedTime / 1000 / 60) % 60;
        this.second = (int) (elapsedTime / 1000) % 60;
    }

    public Time(long elapsedTime) {
        this.hour = (int) (elapsedTime / 1000 / 60 / 60) % 24;
        this.minute = (int) (elapsedTime / 1000 / 60) % 60;
        this.second = (int) (elapsedTime / 1000) % 60;
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setTime(long elapsedTime) {
        this.hour = (int) (elapsedTime / 1000 / 60 / 60) % 24;
        this.minute = (int) (elapsedTime / 1000 / 60) % 60;
        this.second = (int) (elapsedTime / 1000) % 60;
    }
}
