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
}