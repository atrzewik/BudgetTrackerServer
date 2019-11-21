package com.trzewik.budgettrackerserver.domain;

/**
 * @author Agnieszka Trzewik
 */
public class ToLowPriceException extends RuntimeException {
    ToLowPriceException(String message) {
        super(message);
    }
}
