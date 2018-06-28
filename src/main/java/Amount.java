public class Amount {
    private final double value;

    public Amount(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("You cannot withdraw/deposit a negative amount.");
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
