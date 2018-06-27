public class Account {
    private double balance;

    public Account(double balance) {

        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(Amount amount) {
        balance += amount.getValue();
    }

    public void withdraw(Amount amount) {
        if (balance - amount.getValue() < 0) {
            throw new IllegalStateException();
        }
        balance -= amount.getValue();
    }
}
