package com.example.server.services;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;
import com.example.server.models.Statement;
import com.example.server.services.impl.StatementServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatementServiceImplTest {

    @Mock
    private AccountService accountService;

    @InjectMocks
    private StatementServiceImpl statementService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllByAccountIdWillReturnSuccess() {
        final Long id = 123L;

        List<Statement> statements = Arrays.asList(
                Statement.builder().id(333L).date(LocalDate.now()).build(),
                Statement.builder().id(444L).date(LocalDate.now()).build(),
                Statement.builder().id(555L).date(LocalDate.now()).build()
        );

        Account accountToBeFound = Account.builder().id(id).statements(statements).build();

        when(accountService.findById(id)).thenReturn(accountToBeFound);

        List<Statement> result = statementService.findAllByAccountId(id);
        assertEquals(result, statements);
    }

    @Test(expected = AccountNotFoundException.class)
    public void testFindAllWillThrowExceptionWhenAccountNotFound() {
        final Long id = 123L;

        doThrow(AccountNotFoundException.class).when(accountService).findById(id);

        statementService.findAllByAccountId(id);
    }

    @Test(expected = DataSourceNotAvailableException.class)
    public void testFindAllWillThrowExceptionWhenDataSourceNotAvailable() {
        final Long id = 123L;

        doThrow(DataSourceNotAvailableException.class).when(accountService).findById(id);

        statementService.findAllByAccountId(id);
    }



}
