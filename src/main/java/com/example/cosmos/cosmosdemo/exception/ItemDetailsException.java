package com.example.cosmos.cosmosdemo.exception;

/**
 * Created by Nisum on 07-03-2019.
 */
public class ItemDetailsException extends RuntimeException {

    public ItemDetailsException(String message) {
        super(message);
    }

    public ItemDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
