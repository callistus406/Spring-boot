package com.callistus.dataJPA.exception;

public class DuplicateException extends ApiException{

    public DuplicateException(String message) {
        super(message, "DUPLICATE_ENTRY");
    }
}
