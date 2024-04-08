package org.store.booking.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.booking.user.domain.entity.Reservation;

import java.time.LocalDateTime;
import java.util.List;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReservationRepository                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :18:03                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStoreIdIn(List<Long> storeIds);

    List<Reservation> findByStoreIdInOrderByReservationTimeAsc(List<Long> storeIds);

    //폰번호로 예약시간 조회
    List<Reservation> findByUserPhoneNumAndReservationTimeBefore(String userPhoneNum, LocalDateTime reservationTime);

    int deleteByUserPhoneNumAndStoreName(String userPhoneNum, String storeName);

    boolean existsByStoreIdAndUserPhoneNum(Long storeId, String userPhoneNum);
}
