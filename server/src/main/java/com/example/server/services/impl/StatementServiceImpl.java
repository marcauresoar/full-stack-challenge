package com.example.server.services.impl;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;
import com.example.server.models.Statement;
import com.example.server.repositories.DataRepository;
import com.example.server.services.AccountService;
import com.example.server.services.StatementService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class StatementServiceImpl implements StatementService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public List<Statement> findAllByAccountId(Long accountId) throws DataSourceNotAvailableException, AccountNotFoundException {
        log.info(String.format("Fetching account of id %s.", accountId));
        Account account = accountService.findById(accountId);
        log.info("Getting all statements from account.");
        return account.getStatements().stream()
                .sorted(Comparator.comparing(Statement::getDate))
                .collect(Collectors.toList());
    }
}
