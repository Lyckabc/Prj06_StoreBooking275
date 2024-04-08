package org.store.booking.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.store.booking.user.service.ReservationService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReservationController                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :18:01                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Api(tags = "예약 컨트롤러")
@RestController
@RequestMapping("/shop/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    // 예약 생성
    @ApiOperation(value = "예약 생성", notes = "상점 이름과 예약 시간을 설정하여 예약을 생성합니다.")
    @PostMapping("/create")
    public ResponseEntity<String> createReservation(
            @RequestParam("storeName") String storeName,
            @RequestParam("reservationTime") @DateTimeFormat(pattern = "yy-MM-dd'T'HH:mm") LocalDateTime reservationTime,
            HttpServletRequest request) {
        reservationService.createReservation(storeName, reservationTime, request);
        return ResponseEntity.ok("createReservation successfully.");
    }
}
