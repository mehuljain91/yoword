package com.company.socialmediaapp.exceptions;

/**
 *
 * @author mehul jain
 */
public class AppException extends RuntimeException {

    public AppException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public AppException(String exMessage) {
        super(exMessage);
    }
}
