package com.wens.expenseTracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends Exception{

    public TransactionNotFoundException() {
        super();
    }

    public TransactionNotFoundException(String message) {
        super(message);
    }

    public TransactionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionNotFoundException(Throwable cause) {
        super(cause);
    }

    public TransactionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
