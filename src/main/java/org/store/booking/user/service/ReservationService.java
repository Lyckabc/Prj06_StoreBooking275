package org.store.booking.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.store.booking.global.config.JwtTokenProvider;
import org.store.booking.global.exception.impl.store.NotExistStoreException;
import org.store.booking.global.exception.impl.user.NotExistUserException;
import org.store.booking.store.domain.entity.Store;
import org.store.booking.store.domain.repository.StoreRepository;
import org.store.booking.type.EarlyCheck;
import org.store.booking.user.domain.entity.Reservation;
import org.store.booking.user.domain.repository.ReservationRepository;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReservationService                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :18:01                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final StoreRepository storeRepository;

    //예약 생성
    @Transactional
    public void createReservation(String storeName, LocalDateTime reservationTime, HttpServletRequest request) {
        // 토큰으로 phoneNum 가져오기
        String token = jwtTokenProvider.resolveToken(request);
        String phoneNum = jwtTokenProvider.getUserPhoneNum(token);

        // 상점 이름으로 storeId 조회
        Store store = storeRepository.findByStoreName(storeName);
        if (store == null) {
            // 상점이 존재하지 않을 경우 처리
            throw new NotExistStoreException();
        }
        // 예약 생성을 위해 필요한 값들을 사용하여 Reservation 엔티티를 생성
        Reservation reservation = Reservation.builder()
                .userPhoneNum(phoneNum)
                .storeName(storeName)
                .storeId(store.getStoreId())
                .reservationTime(reservationTime)
                .build();

        // 예약 데이터를 데이터베이스에 저장
        reservationRepository.save(reservation);
    }

    //10분전에 와서 확인
    @Transactional
    public void checkReservation(String userPhoneNum) {
        if (userPhoneNum != null && !userPhoneNum.isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            List<Reservation> reservations = reservationRepository.findByUserPhoneNumAndReservationTimeBefore(userPhoneNum, now);

            for (Reservation reservation : reservations) {
                reservation.setComeCheck(EarlyCheck.COME);
                reservationRepository.save(reservation);
            }
        } else {
            throw new NotExistUserException();
        }
    }
}
