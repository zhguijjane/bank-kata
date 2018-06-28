package domain;

public class Amount {
    private final long value;

    public Amount(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("You cannot withdraw/deposit a negative amount.");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
