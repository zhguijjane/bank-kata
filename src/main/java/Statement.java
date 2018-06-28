import java.time.LocalDate;


public class Statement {
    private final String operationType;
    private final LocalDate localDate;
    private final Amount amount;
    private final int balance;

    public Statement(String operationType, LocalDate localDate, Amount amount, int balance) {
        this.operationType = operationType;
        this.localDate = localDate;
        this.amount = amount;
        this.balance = balance;
    }


    public void print(Printer printString) {
        printString.print(this.toString());
    }

    @Override
    public String toString() {
        return operationType + " | " + localDate + " | " + amount + " | " + balance;
    }
}
