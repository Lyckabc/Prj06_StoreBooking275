package org.store.booking.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.store.booking.user.domain.entity.User;
import org.store.booking.global.exception.impl.user.NotExistUserException;
import org.store.booking.user.domain.repository.UserRepository;

import java.util.Collections;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        PartnerService                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:35                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Service
@RequiredArgsConstructor
public class PartnerService {

    private final UserRepository userRepository;
    //권한 변경
    public void changeRole(String userPhoneNum) {
        User member = userRepository.findByUserPhoneNum(userPhoneNum)
                .orElseThrow(NotExistUserException::new);

        member.setRoles(Collections.singletonList("ADMIN")); // roles를 "ADMIN"으로 변경

        userRepository.save(member);
    }
}
