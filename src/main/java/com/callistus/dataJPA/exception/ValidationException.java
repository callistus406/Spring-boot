package com.callistus.dataJPA.exception;

public class ValidationException extends ApiException{

    public ValidationException(String message) {
        super(message,"VALIDATION_ERROR");
    }

}
