package org.store.booking.store.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.store.booking.global.BaseEntity;

import javax.persistence.*;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        Store                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:27                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Entity
@Setter
@Getter
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;//매장 번호
    private String userPhoneNum; //사장인지 확인하기 위한 사장 핸드폰번호(여기선 ID로 쓰임)

    @Column(unique = true)
    private String storeName; //매장 이름

    private String storeLocation; //매장 위치
    private String storeDescription; //매장 설명

    private int distance; //매장으로부터의 거리 (javaScript를 통해 내 위치를 가져올 수 없어, 거리를 직접 지정하여 거리순으로 sort 할 예정)
    //    @Enumerated(EnumType.STRING)
//    private StarRating rating; //별점은 Enum으로 정의하여 1~5점만 가능하도록
    @Column(columnDefinition = "DOUBLE(3, 1) CHECK (average_rating >= 0.0 AND average_rating <= 5.0)")
    private double averageRating;
    private Long totalRating;
    private int totalReviewCount;
}
