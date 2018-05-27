package com.example.server.services.impl;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;
import com.example.server.repositories.DataRepository;
import com.example.server.services.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class AccountServiceImpl implements AccountService {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public List<Account> findAll() throws DataSourceNotAvailableException {
        log.info("Fetching all accounts in repository.");
        return dataRepository.readFileContents();
    }

    @Override
    public Account findById(Long id) throws DataSourceNotAvailableException, AccountNotFoundException {
        log.info("Fetching all accounts in repository.");
        List<Account> accounts = dataRepository.readFileContents();
        Optional<Account> account = accounts.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();

        if(account.isPresent()) {
            log.info(String.format("Found account of id %s.", id));
            return account.get();
        }
        log.info(String.format("Couldn't find account of id %s.", id));
        throw new AccountNotFoundException(String.format("Account of id %s not found!", id));
    }
}
