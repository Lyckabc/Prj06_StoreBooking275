package org.store.booking.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.booking.user.domain.entity.Review;

import java.util.List;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReviewRepository                                  **
 **        Made by dong-hoshin                          **
 **        4/10/24 :21:56                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByStoreId(Long storeId);
}

