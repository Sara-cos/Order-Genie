package com.tesseract.ordergenie.exception;

public class EmployeeDoesNotExistException extends Exception{
    public EmployeeDoesNotExistException() {
    }

    public EmployeeDoesNotExistException(String message) {
        super(message);
    }
}
