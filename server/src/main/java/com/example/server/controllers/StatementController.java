package com.example.server.controllers;

import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Statement;
import com.example.server.services.StatementService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statement")
@Log4j2
public class StatementController {

    @Autowired
    private StatementService statementService;

    @GetMapping(value = "/list/{accountId}")
    public List<Statement> findAllByAccountId(@PathVariable("accountId") Long accountId) throws DataSourceNotAvailableException {
        log.info("Calling findAllByAccountId function from statementService.");
        return statementService.findAllByAccountId(accountId);
    }

}
