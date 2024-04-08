package org.store.booking.global.exception.impl.store;

import org.springframework.http.HttpStatus;
import org.store.booking.global.exception.AbstractException;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        NotExistStoreException                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :18:14                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class NotExistStoreException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "존재하지 않는 상점입니다.";
    }
}
