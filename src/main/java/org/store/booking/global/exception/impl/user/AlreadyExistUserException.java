package org.store.booking.global.exception.impl.user;

import org.springframework.http.HttpStatus;
import org.store.booking.global.exception.AbstractException;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        AlreadyExistUserException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :14:01                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class AlreadyExistUserException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 존재하는 사용자 휴대폰 번호입니다.";
    }
}
