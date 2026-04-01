package com.example.springpracticetamerlan.Exception;

public class UserAlreadyExistException extends  RuntimeException{
    public UserAlreadyExistException () {
        super();
    }
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
