package com.callistus.dataJPA.exception;



public class ResourceNotFoundException extends ApiException {
    public ResourceNotFoundException(String message) {
        
        super(message, "RESOURCE_NOT_FOUND");
    }

    
}