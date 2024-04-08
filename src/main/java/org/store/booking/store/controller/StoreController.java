package org.store.booking.store.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.store.booking.store.domain.dto.StoreDto;
import org.store.booking.store.service.StoreService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        StoreController                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:24                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/

@Api(tags = "상점 컨트롤러")
@RestController
@RequestMapping("/shop/v1/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @ApiOperation(value = "상점 등록", notes = "파트너 권한을 가진 유저가 상점을 등록합니다.")
    @PostMapping("/register")
    public ResponseEntity<String> registerStore(@RequestBody StoreDto storeDto, HttpServletRequest request) {
        boolean success = storeService.registerStore(storeDto, request);

        if (success) {
            return ResponseEntity.ok("Store registered successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Only ADMIN users can register a store.");
        }
    }

    // 모든 매장 정보 확인
    @ApiOperation(value = "상점 전체 조회", notes = "모든 매장의 목록을 확인합니다.")
    @GetMapping("/view")
    public List<Map<String, Object>> getAllStores() {
        return storeService.getAllStores();
    }
}
