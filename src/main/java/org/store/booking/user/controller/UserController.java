package org.store.booking.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.store.booking.user.domain.dto.UserCreateDto;
import org.store.booking.user.domain.dto.UserDeleteDto;
import org.store.booking.user.domain.dto.UserReadDto;
import org.store.booking.user.domain.entity.User;
import org.store.booking.user.service.UserService;

import java.util.List;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        UserController                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :14:04                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Api(tags = "회원 컨트롤러")
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

    @ApiOperation(value = "회원 목록", notes = "모든 회원들의 목록(아이디,비번) 열람")
    @GetMapping("/list")
    public ResponseEntity<List<UserReadDto>> list() {
        List<UserReadDto> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @ApiOperation(value = "회원 탈퇴", notes = "아이디(휴대폰 번호), 비밀번호를 통해 회원탈퇴 요청을 보냅니다.")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserDeleteDto userDeleteDto) {
        userService.deleteUser(userDeleteDto.getUserPhoneNum(), userDeleteDto.getUserPassword());
        return ResponseEntity.ok("delete successfully");
    }

    @ApiOperation(value = "로그인", notes = "jwt 토큰을 사용하여 로그인시 토큰을 부여합니다.")
    @PostMapping("/login")
    public String login(@RequestBody UserCreateDto userCreateDto) {
        return "Bearer " + userService.login(userCreateDto);
    }
}
