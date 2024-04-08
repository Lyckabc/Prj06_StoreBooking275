package org.store.booking.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    // 예약 체크
    @ApiOperation(value = "10분전 예약 확인", notes = "예약시간 10분전에 키오스크를 통해 가게에 도착했다는 인증을 합니다.")
    @GetMapping("/check")
    public ResponseEntity<String> checkReservation(@RequestParam("userPhoneNum") String userPhoneNum) {
        reservationService.checkReservation(userPhoneNum);
        return ResponseEntity.ok("checkReservation successfully.");
    }
}
