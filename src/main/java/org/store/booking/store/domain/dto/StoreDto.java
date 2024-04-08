package org.store.booking.store.domain.dto;

import lombok.*;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        StoreDto                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:26                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreDto {
    private String storeName; //매장 이름
    private String storeLocation; //매장 위치
    private String storeDescription; //매장 설명
    private int distance; //매장으로부터의 거리 (javaScript를 통해 내 위치를 가져올 수 없어, 거리를 직접 지정하여 거리순으로 sort 할 예정)
}
