package com.backfcdev.servicerestbasic.exception;

public class ExistingDni extends RuntimeException {
    public ExistingDni(String dni){
        super("The DNI "+dni+" already exists");
    }
}
