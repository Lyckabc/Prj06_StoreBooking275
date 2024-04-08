package org.store.booking.store.service;

import org.store.booking.global.config.JwtTokenProvider;
import org.store.booking.global.exception.impl.role.UnauthorizedException;
import org.store.booking.global.exception.impl.store.AlreadyExistStoreException;
import org.store.booking.store.domain.dto.StoreDto;
import org.store.booking.store.domain.entity.Store;
import org.store.booking.store.domain.repository.StoreRepository;

import javax.servlet.http.HttpServletRequest;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        StoreService                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :16:28                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
public class StoreService {
    private final StoreRepository storeRepository;
    private final JwtTokenProvider jwtTokenProvider;

    //상점 등록
    public boolean registerStore(StoreDto storeDto, HttpServletRequest request) {
        // 토큰을 통해 사용자 정보를 가져옴
        String token = jwtTokenProvider.resolveToken(request);

        // 토큰에서 전화번호 추출
        String userPhoneNum = jwtTokenProvider.getUserPhoneNum(token);

        if (jwtTokenProvider.userHasAdminRole(token)) { // 권한이 있어야 store 등록 가능
            //상점 이름 중복 확인
            if (storeRepository.existsByStoreName(storeDto.getStoreName())) {
                throw new AlreadyExistStoreException();
            }
            Store store = new Store();
            store.setStoreName(storeDto.getStoreName());
            store.setStoreLocation(storeDto.getStoreLocation());
            store.setStoreDescription(storeDto.getStoreDescription());
            store.setUserPhoneNum(userPhoneNum);
            store.setDistance(storeDto.getDistance());
            store.setAverageRating(0.0);
            store.setTotalReviewCount(0);
            storeRepository.save(store);
            return true;
        } else {
            throw new UnauthorizedException();
        }
    }
}
