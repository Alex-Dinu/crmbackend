package com.ceme.crm.customExceptions;

public class CustomerNotFoundException extends Exception{

    public CustomerNotFoundException(){}

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
