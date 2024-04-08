package org.store.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/****************************************************
 **                                                 **
 **        Default (Template) Project                          **
 **        ${NAME}                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :13:20                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/

@SpringBootApplication
@EnableJpaAuditing
public class StoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}