package com.xin.note.common.exception;

/**
 * @author xin
 */
public class AppException extends RuntimeException{

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message){
        super(message);
    }
}

