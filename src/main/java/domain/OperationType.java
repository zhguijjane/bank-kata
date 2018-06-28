package domain;

public enum OperationType {
    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw");

    private String operation;

    OperationType(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return operation;
    }
}
