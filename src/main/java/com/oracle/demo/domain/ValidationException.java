package com.oracle.demo.domain;

public class ValidationException extends RuntimeException{
    public ValidationException(String message){
        super(message);
    }
}
