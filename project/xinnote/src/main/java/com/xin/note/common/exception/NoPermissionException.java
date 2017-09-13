package com.xin.note.common.exception;

/**
 * @author xin
 */
public class NoPermissionException extends RuntimeException{

    public NoPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPermissionException(String message){
        super(message);
    }
}

