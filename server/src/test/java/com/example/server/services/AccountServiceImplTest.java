package com.example.server.services;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;
import com.example.server.repositories.DataRepository;
import com.example.server.services.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceImplTest {

    @Mock
    private DataRepository dataRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllWillReturnSuccess() {
        List<Account> accounts = Arrays.asList(
                Account.builder().id(123L).build(),
                Account.builder().id(456L).build(),
                Account.builder().id(789L).build()
        );

        when(dataRepository.readFileContents()).thenReturn(accounts);

        List<Account> result = accountService.findAll();
        assertEquals(result, accounts);
    }

    @Test(expected = DataSourceNotAvailableException.class)
    public void testFindAllWillThrowExceptionWhenDataSourceNotAvailable() {
        doThrow(DataSourceNotAvailableException.class).when(dataRepository).readFileContents();

        accountService.findAll();
    }

    @Test
    public void testFindByIdWillReturnSuccess() {
        final Long id = 123L;

        List<Account> accounts = Arrays.asList(
                Account.builder().id(id).build(),
                Account.builder().id(456L).build(),
                Account.builder().id(789L).build()
        );

        when(dataRepository.readFileContents()).thenReturn(accounts);

        Account account = accountService.findById(id);
        assertNotNull(account);
    }

    @Test(expected = AccountNotFoundException.class)
    public void testFindByIdWillThrowExceptionWhenAccountNotFound() {
        final Long id = 123L;

        List<Account> accounts = Arrays.asList(
                Account.builder().id(456L).build(),
                Account.builder().id(789L).build()
        );

        when(dataRepository.readFileContents()).thenReturn(accounts);

        accountService.findById(id);
    }

    @Test(expected = DataSourceNotAvailableException.class)
    public void testFindByIdWillThrowExceptionWhenDataSourceNotAvailable() {
        final Long id = 123L;

        doThrow(DataSourceNotAvailableException.class).when(dataRepository).readFileContents();

        accountService.findById(id);
    }

}
