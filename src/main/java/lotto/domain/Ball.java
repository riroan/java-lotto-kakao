package lotto.domain;

public class Ball implements Comparable<Ball> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private int number;

    public Ball(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RuntimeException();
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Ball ball) {
        return Integer.compare(number, ball.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ball) {
            return number == ((Ball) obj).getNumber();
        }
        return false;
    }
}
