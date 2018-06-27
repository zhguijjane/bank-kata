import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(0);
    }

    @Test
    public void should_add_0_to_account() {
        account.deposit(new Amount(0));

        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void should_add_100_to_account() {
        account.deposit(new Amount(100));

        Assertions.assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void should_add_100_twice_to_account() {
        account.deposit(new Amount(100));
        account.deposit(new Amount(100));

        Assertions.assertThat(account.getBalance()).isEqualTo(200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_deposit_negative_value() {
        account.deposit(new Amount(-10));
    }


    @Test
    public void should_withdraw_0_from_the_account() {
        account.withdraw(new Amount(0));

        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void should_withdraw_50_from_the_account() {
        account = new Account(100);
        account.withdraw(new Amount(50));

        Assertions.assertThat(account.getBalance()).isEqualTo(50);
    }

    @Test
    public void should_withdraw_50_twice_from_the_account() {
        account = new Account(100);
        account.withdraw(new Amount(50));
        account.withdraw(new Amount(50));

        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_authorize_withdraw_negative_value() {
        account.withdraw(new Amount(-10));
    }
}