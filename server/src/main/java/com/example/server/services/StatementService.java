package com.example.server.services;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Statement;

import java.util.List;

public interface StatementService {
    List<Statement> findAllByAccountId(Long accountId) throws DataSourceNotAvailableException, AccountNotFoundException;
}
