package org.store.booking.global.exception.impl.user;

import org.springframework.http.HttpStatus;
import org.store.booking.global.exception.AbstractException;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        NotExistUserException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:00                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class NotExistUserException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "존재하지 않는 사용자입니다.";
    }
}
