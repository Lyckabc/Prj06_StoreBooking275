package org.store.booking.store.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.store.booking.store.domain.entity.Store;

import java.util.List;
import java.util.Optional;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        StoreRepository                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:28                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public interface StoreRepository extends JpaRepository<Store, Long> {
    Store findByStoreName(String storeName);
    boolean existsByStoreName(String storeName);

    Store findIdByStoreName(String storeName);

    List<Store> findByUserPhoneNum(String userPhoneNum);

    Optional<Store> findByStoreId(Long storeId);

    Long findStoreIdByStoreName(String storeName);
}