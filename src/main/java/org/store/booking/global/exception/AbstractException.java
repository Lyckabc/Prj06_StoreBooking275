package org.store.booking.global.exception;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        AbstractException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :13:39                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public abstract class AbstractException extends RuntimeException{
    abstract public int getStatusCode();
    abstract public String getMessage();
}
