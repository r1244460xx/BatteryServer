package com.symbol.BatteryServer.exception;

public class DbConnFailException extends RuntimeException {
    public DbConnFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
