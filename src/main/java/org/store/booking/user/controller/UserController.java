package org.store.booking.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.booking.user.domain.dto.UserCreateDto;
import org.store.booking.user.service.UserService;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        UserController                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :14:04                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
//@Api(tags = "회원 컨트롤러")
@RestController
@RequestMapping("/shop/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "회원 가입", notes = "아이디(휴대폰 번호), 비밀번호를 통해 회원가입 요청을 보냅니다.")
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserCreateDto userCreateDto) {
        userService.join(userCreateDto);
        return ResponseEntity.ok("join successfully");
    }
}
