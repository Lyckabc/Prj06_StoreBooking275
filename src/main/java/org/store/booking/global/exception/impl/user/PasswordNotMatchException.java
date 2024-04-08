package org.store.booking.global.exception.impl.user;

import org.springframework.http.HttpStatus;
import org.store.booking.global.exception.AbstractException;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        PasswordNotMatchException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :15:59                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class PasswordNotMatchException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "비밀번호가 일치하지 않습니다";
    }
}
