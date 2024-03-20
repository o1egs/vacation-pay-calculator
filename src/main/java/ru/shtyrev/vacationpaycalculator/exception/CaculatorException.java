package ru.shtyrev.vacationpaycalculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CaculatorException extends Exception {
    public CaculatorException() {
        super();
    }

    public CaculatorException(String message) {
        super(message);
    }

    public CaculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CaculatorException(Throwable cause) {
        super(cause);
    }

    protected CaculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
