package com.example.esercizio1Spring.parte2;

public class EmailNotValidException extends Exception {

    @Override
    public String getMessage() {
        return "email non valida!";
    }
}
