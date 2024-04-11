package org.store.booking.user.domain.entity;

import lombok.*;
import org.store.booking.global.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        Review                                  **
 **        Made by dong-hoshin                          **
 **        4/10/24 :21:56                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Entity
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId; //리뷰 아이디

    private String userPhoneNum; //유저 아이디
    private Long storeId;//상점 아이디
    private String storeName;//상점 이름
    private String reviewText; //리뷰 텍스트
    private int starRating; //별점
}
