package com.zaheer.SpringBootTutorial.exception;

public class StudentIdMismatchException extends  RuntimeException {

    public StudentIdMismatchException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public StudentIdMismatchException()
    {
        super();
    }
}
