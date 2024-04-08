package org.store.booking.user.domain.dto;

import lombok.*;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        UserDeleteDto                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:01                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDeleteDto {
    private String userPhoneNum;//유저 휴대폰 번호 겸 아이디
    private String userPassword;//유저 비밀번호
}
