package com.spring_boot.spring_boot.Learn;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException() {
        super();
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }
    
    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}