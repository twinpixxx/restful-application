package com.labs.restservice.exception.InternalException;

public class InternalArithmeticException extends ArithmeticException {

    private int exceptionCode;

    public InternalArithmeticException(String message) {
        super(message);
    }
    public InternalArithmeticException(String message, int exceptionCode) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}
