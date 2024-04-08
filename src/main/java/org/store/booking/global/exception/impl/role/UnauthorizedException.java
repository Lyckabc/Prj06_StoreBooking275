package org.store.booking.global.exception.impl.role;

import org.springframework.http.HttpStatus;
import org.store.booking.global.exception.AbstractException;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        UnauthorizedException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:30                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class UnauthorizedException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "옳지 않은 권한을 통한 접근입니다.";
    }
}
