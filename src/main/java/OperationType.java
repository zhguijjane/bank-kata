public enum OperationType {
    DEPOSIT("Deposit");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return operation;
    }
}
