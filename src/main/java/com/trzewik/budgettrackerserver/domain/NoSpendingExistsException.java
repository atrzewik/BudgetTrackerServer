package com.trzewik.budgettrackerserver.domain;

/**
 * @author Agnieszka Trzewik
 */
public class NoSpendingExistsException extends Exception {
    NoSpendingExistsException(String message) {
        super(message);
    }
}
