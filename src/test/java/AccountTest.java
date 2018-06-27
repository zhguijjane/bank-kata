import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AccountTest {

    @Test
    public void should_add_0_to_account() {
        Account account = new Account(0);

        account.deposit(new Amount(0));

        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void should_add_100_to_account() {
        Account account = new Account(0);

        account.deposit(new Amount(100));

        Assertions.assertThat(account.getBalance()).isEqualTo(100);
    }
}