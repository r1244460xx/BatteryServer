package com.symbolmarine.BatteryManager.exception;

public class DbConnFailException extends RuntimeException {
    public DbConnFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
