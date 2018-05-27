package com.example.server.services;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll() throws DataSourceNotAvailableException;
    Account findById(Long id) throws DataSourceNotAvailableException, AccountNotFoundException;
}
