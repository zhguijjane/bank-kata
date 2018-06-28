package domain;

import exception.WithdrawException;
import service.DateService;
import service.Printer;

import java.util.ArrayList;
import java.util.List;

class Account {
    private long balanceInCents;
    private final DateService dateService;

    private final List<Statement> statements = new ArrayList<>();

    public Account(long balanceInCents, DateService dateService) {
        this.balanceInCents = balanceInCents;
        this.dateService = dateService;
    }

    long getBalanceInCents() {
        return balanceInCents;
    }

    void deposit(Amount amount) {
        createStatement(amount, OperationType.DEPOSIT);
        balanceInCents += amount.getValue();
    }

    void withdraw(Amount amount) throws WithdrawException {
        if (isWithdrawNegativeResult(amount)) {
            throw new WithdrawException("You cannot withdraw an amount you do not have on your account.");
        }
        createStatement(amount, OperationType.WITHDRAW);
        balanceInCents -= amount.getValue();
    }

    private boolean isWithdrawNegativeResult(Amount amount) {
        return balanceInCents - amount.getValue() < 0;
    }

    void printAllStatement(Printer printer) {
        statements.forEach(statement -> statement.print(printer));
    }

    private void createStatement(Amount amount, OperationType deposit) {
        Statement statement = new Statement.StatementBuilder()
                .operationType(deposit)
                .localDate(dateService.now())
                .amount(amount)
                .balance(balanceInCents)
                .build();
        statements.add(statement);
    }
}
