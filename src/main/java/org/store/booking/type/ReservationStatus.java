package org.store.booking.type;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReservationStatus                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :18:05                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public enum ReservationStatus {
    REFUSE,
    PLEASE_WAIT,
    OKAY;

    public static final ReservationStatus DEFAULT = PLEASE_WAIT;
}
