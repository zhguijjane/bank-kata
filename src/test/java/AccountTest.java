import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(0);
    }

    @Test
    public void should_add_0_to_account() {
        account.deposit(new Amount(0));

        Assertions.assertThat(account.getBalanceInCents()).isEqualTo(0);
    }

    @Test
    public void should_add_100_to_account() {
        account.deposit(new Amount(100));

        Assertions.assertThat(account.getBalanceInCents()).isEqualTo(100);
    }

    @Test
    public void should_add_100_twice_to_account() {
        account.deposit(new Amount(100));
        account.deposit(new Amount(100));

        Assertions.assertThat(account.getBalanceInCents()).isEqualTo(200);
    }

    @Test
    public void should_not_authorize_deposit_negative_value() {
        assertThatThrownBy(() -> account.deposit(new Amount(-10))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You cannot withdraw/deposit a negative amount.");
    }


    @Test
    public void should_withdraw_0_from_the_account() throws WithdrawException {
        account.withdraw(new Amount(0));

        Assertions.assertThat(account.getBalanceInCents()).isEqualTo(0);
    }

    @Test
    public void should_withdraw_50_from_the_account() throws WithdrawException {
        account = new Account(100);
        account.withdraw(new Amount(50));

        Assertions.assertThat(account.getBalanceInCents()).isEqualTo(50);
    }

    @Test
    public void should_withdraw_50_twice_from_the_account() throws WithdrawException {
        account = new Account(100);
        account.withdraw(new Amount(50));
        account.withdraw(new Amount(50));

        Assertions.assertThat(account.getBalanceInCents()).isEqualTo(0);
    }

    @Test
    public void should_not_authorize_withdraw_negative_value() {
        assertThatThrownBy(() -> account.withdraw(new Amount(-10))).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You cannot withdraw/deposit a negative amount.");
    }

    @Test
    public void should_not_authorize_withdrawal_an_amount_which_is_not_present_in_an_account() {
        assertThatThrownBy(() -> account.withdraw(new Amount(10))).isInstanceOf(WithdrawException.class)
                .hasMessageContaining("You cannot withdraw an amount you do not have on your account.");
    }

    @Test
    public void should_get_precision_for_withdrawal() throws WithdrawException {
        account = new Account(103);
        account.withdraw(new Amount(42));

        assertThat(account.getBalanceInCents()).isEqualTo(61);
    }
}