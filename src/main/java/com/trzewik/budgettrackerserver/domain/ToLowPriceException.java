package com.trzewik.budgettrackerserver.domain;

/**
 * @author Agnieszka Trzewik
 */
public class ToLowPriceException extends Exception {
    ToLowPriceException(String message) {
        super(message);
    }
}
