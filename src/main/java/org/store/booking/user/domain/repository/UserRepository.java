package org.store.booking.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.booking.user.domain.entity.User;

import java.util.Optional;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        UserRepository                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :13:49                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserPhoneNum(String userPhoneNum);

    boolean existsByUserPhoneNum(String userPhoneNum);
}
