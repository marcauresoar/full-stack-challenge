package com.example.server.controllers;

import com.example.server.exceptions.AccountNotFoundException;
import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;
import com.example.server.services.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@Log4j2
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/list")
    public List<Account> findAll() throws DataSourceNotAvailableException {
        log.info("Calling findAll function from accountService.");
        return accountService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Account findById(@PathVariable("id") Long id) throws DataSourceNotAvailableException, AccountNotFoundException {
        log.info("Calling findById function from accountService.");
        return accountService.findById(id);
    }

}