public class Amount {
    private final double value;

    public Amount(double value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
