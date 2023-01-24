package com.backfcdev.servicerestbasic.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Long id){
        super("Could not found the person with id " + id);
    }
}
