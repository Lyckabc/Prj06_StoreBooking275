package org.store.booking.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.store.booking.global.exception.impl.user.AlreadyExistUserException;
import org.store.booking.user.domain.dto.UserCreateDto;
import org.store.booking.user.domain.entity.User;
import org.store.booking.user.domain.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Collections;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        UserService                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :13:48                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //Register
    @Transactional
    public void join(UserCreateDto userCreateDto) {
        String userPhoneNum = userCreateDto.getUserPhoneNum();

        // is there exist ID
        if (userRepository.existsByUserPhoneNum(userPhoneNum)) {
            throw new AlreadyExistUserException();
        }

        User user = User.builder()
                .userPhoneNum(userPhoneNum)
                .userPassword(passwordEncoder.encode(userCreateDto.getUserPassword()))
                .roles(Collections.singletonList("USER"))
                .build();

        userRepository.save(user);
    }
}
