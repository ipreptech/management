package com.ipreptech.management.exceptions;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String msg) {
        super(msg);
    }

    StudentNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
