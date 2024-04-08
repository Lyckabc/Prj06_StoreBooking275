package org.store.booking.global.exception.impl.store;

import org.springframework.http.HttpStatus;
import org.store.booking.global.exception.AbstractException;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        AlreadyExistStoreException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:30                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class AlreadyExistStoreException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 존재하는 상점 이름입니다.";
    }
}
