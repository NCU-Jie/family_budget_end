package com.budget.exception;

public class UsernameAlreadyExistException extends BaseException {

    public UsernameAlreadyExistException() {
    }

    public UsernameAlreadyExistException(String msg) {
        super(msg);
    }

}