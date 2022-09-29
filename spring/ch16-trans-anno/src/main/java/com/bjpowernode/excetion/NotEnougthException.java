package com.bjpowernode.excetion;

/**
 *  运行时异常
 */
public class NotEnougthException extends RuntimeException {
    public NotEnougthException() {
        super();
    }

    public NotEnougthException(String message) {
        super(message);
    }
}
