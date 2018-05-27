package com.example.server.exceptions;

public class DataSourceNotAvailableException extends RuntimeException {
    public DataSourceNotAvailableException(String message) {
        super(message);
    }
}
