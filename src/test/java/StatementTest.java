import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    @Mock
    private Printer printer;

    @Mock
    private DateService dateService;

    @Test
    public void should_print_statement_for_deposit() {
        when(dateService.now()).thenReturn(LocalDate.of(2018, 6, 28));
        Amount amount = new Amount(500);
        int balance = 0;

        Statement statement = new Statement.StatementBuilder()
                .operationType(OperationType.DEPOSIT)
                .localDate(dateService.now())
                .amount(amount)
                .balance(balance)
                .build();

        statement.print(printer);
        Mockito.verify(printer).print("Deposit | 2018-06-28 | 500 | 0");
    }
}