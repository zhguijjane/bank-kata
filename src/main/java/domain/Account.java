package domain;

import exception.WithdrawException;
import service.DateService;
import service.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Account {
    private long balanceInCents;
    private DateService dateService;

    private List<Statement> statements = new ArrayList<>();

    public Account(long balanceInCents, DateService dateService) {
        this.balanceInCents = balanceInCents;
        this.dateService = dateService;
    }

    public double getBalanceInCents() {
        return balanceInCents;
    }

    public void deposit(Amount amount) {
        Statement statement = new Statement.StatementBuilder()
                .operationType(OperationType.DEPOSIT)
                .localDate(dateService.now())
                .amount(amount)
                .balance(balanceInCents)
                .build();
        statements.add(statement);
        balanceInCents += amount.getValue();
    }

    public void withdraw(Amount amount) throws WithdrawException {
        if (balanceInCents - amount.getValue() < 0) {
            throw new WithdrawException("You cannot withdraw an amount you do not have on your account.");
        }
        Statement statement = new Statement.StatementBuilder()
                .operationType(OperationType.WITHDRAW)
                .localDate(dateService.now())
                .amount(amount)
                .balance(balanceInCents)
                .build();
        statements.add(statement);
        balanceInCents -= amount.getValue();
    }

    public void printAllStatement(Printer printer) {
        statements.forEach(statement -> statement.print(printer));
    }
}
