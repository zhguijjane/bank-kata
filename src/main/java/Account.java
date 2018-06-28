import java.math.BigDecimal;

public class Account {
    private long balanceInCents;

    public Account(long balanceInCents) {
        this.balanceInCents = balanceInCents;
    }

    public double getBalanceInCents() {
        return balanceInCents;
    }

    public void deposit(Amount amount) {
        balanceInCents += amount.getValue();
    }

    public void withdraw(Amount amount) throws WithdrawException {
        if (balanceInCents - amount.getValue() < 0) {
            throw new WithdrawException("You cannot withdraw an amount you do not have on your account.");
        }
        balanceInCents -= amount.getValue();
    }

}
