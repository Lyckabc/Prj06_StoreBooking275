package org.store.booking.global.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.store.booking.user.domain.entity.User;
import org.store.booking.user.domain.repository.UserRepository;

import java.util.Optional;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        CustomUserDetailService                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :15:38                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userPhoneNum) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserPhoneNum(userPhoneNum);
        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return user;
    }

}
