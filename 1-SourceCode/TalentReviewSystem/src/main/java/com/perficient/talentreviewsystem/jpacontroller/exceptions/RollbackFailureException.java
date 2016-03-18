package com.perficient.talentreviewsystem.jpacontroller.exceptions;

public class RollbackFailureException extends Exception {
    public RollbackFailureException(String message, Throwable cause) {
        super(message, cause);
    }
    public RollbackFailureException(String message) {
        super(message);
    }
}