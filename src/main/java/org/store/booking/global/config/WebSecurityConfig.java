package org.store.booking.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        WebSecurityConfig                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :14:12                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
