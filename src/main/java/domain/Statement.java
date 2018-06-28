package domain;

import lombok.Builder;
import service.Printer;

import java.time.LocalDate;

@Builder
public class Statement {
    private final OperationType operationType;
    private final LocalDate localDate;
    private final Amount amount;
    private final long balance;

    public Statement(OperationType operationType, LocalDate localDate, Amount amount, long balance) {
        this.operationType = operationType;
        this.localDate = localDate;
        this.amount = amount;
        this.balance = balance;
    }

    void print(Printer printString) {
        printString.print(this.toString());
    }

    @Override
    public String toString() {
        return operationType + " | " + localDate + " | " + amount + " | " + balance;
    }
}