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
        balance -= amount.getValue();
    }
}
