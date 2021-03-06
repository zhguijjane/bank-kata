package domain;

import exception.WithdrawException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import service.DateService;
import service.Printer;

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

    @Test
    public void should_print_statement_for_withdrawal() {
        when(dateService.now()).thenReturn(LocalDate.of(2018, 6, 28));
        Amount amount = new Amount(300);
        int balance = 0;

        Statement statement = new Statement.StatementBuilder()
                .operationType(OperationType.WITHDRAW)
                .localDate(dateService.now())
                .amount(amount)
                .balance(balance)
                .build();

        statement.print(printer);
        Mockito.verify(printer).print("Withdraw | 2018-06-28 | 300 | 0");
    }

    @Test
    public void should_print_all_the_statement() throws WithdrawException {
        when(dateService.now()).thenReturn(
                LocalDate.of(2018, 6, 26),
                LocalDate.of(2018, 6, 27),
                LocalDate.of(2018, 6, 28));

        Account account = new Account(0, dateService);

        account.deposit(new Amount(1000));
        account.withdraw(new Amount(300));
        account.deposit(new Amount(200));

        account.printAllStatement(printer);

        Mockito.verify(printer).print("Deposit | 2018-06-26 | 1000 | 0");
        Mockito.verify(printer).print("Withdraw | 2018-06-27 | 300 | 1000");
        Mockito.verify(printer).print("Deposit | 2018-06-28 | 200 | 700");
    }
}