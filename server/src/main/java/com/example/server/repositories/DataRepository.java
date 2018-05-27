package com.example.server.repositories;

import com.example.server.exceptions.DataSourceNotAvailableException;
import com.example.server.models.Account;

import java.util.List;

public interface DataRepository {
    List<Account> readFileContents() throws DataSourceNotAvailableException;
}
