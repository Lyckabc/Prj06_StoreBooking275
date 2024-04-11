package org.store.booking.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.store.booking.global.config.JwtTokenProvider;
import org.store.booking.global.exception.impl.reservation.NotUseThisStoreException;
import org.store.booking.global.exception.impl.store.NotExistStoreException;
import org.store.booking.store.domain.entity.Store;
import org.store.booking.store.domain.repository.StoreRepository;
import org.store.booking.user.domain.dto.ReviewDto;
import org.store.booking.user.domain.entity.Review;
import org.store.booking.user.domain.repository.ReservationRepository;
import org.store.booking.user.domain.repository.ReviewRepository;

import javax.servlet.http.HttpServletRequest;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReviewService                                  **
 **        Made by dong-hoshin                          **
 **        4/10/24 :21:55                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final JwtTokenProvider jwtTokenProvider;
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final ReservationRepository reservationRepository;

    //리뷰 생성
    @Transactional
    public void createReview(ReviewDto reviewDto, HttpServletRequest request) {
        // 토큰으로부터 사용자 핸드폰 번호 가져오기
        String token = jwtTokenProvider.resolveToken(request);
        String userPhoneNum = jwtTokenProvider.getUserPhoneNum(token);

        // 상점 ID 조회
        String storeName = reviewDto.getStoreName();
        Store store = storeRepository.findByStoreName(storeName);
        if (store == null) {
            throw new NotExistStoreException();
        }

        //상점 이용하지 않은 고객이 이용하려고 할 때
        // 예약한 고객인지 확인하여 음식을 먹었는지 검토
        boolean hasReservation = reservationRepository.existsByStoreIdAndUserPhoneNum(store.getStoreId(), userPhoneNum);
        if (!hasReservation) {
            throw new NotUseThisStoreException();
        }

        // 새로운 리뷰 엔티티 생성
        Review review = Review.builder()
                .userPhoneNum(userPhoneNum)
                .storeId(store.getStoreId())
                .storeName(store.getStoreName())
                .reviewText(reviewDto.getReviewText())
                .starRating(reviewDto.getStarRating())
                .build();

        // 리뷰를 데이터베이스에 저장
        reviewRepository.save(review);

        // 상점의 총 별점 총점과 리뷰 개수 업데이트
        double newTotalRating = store.getTotalRating() + review.getStarRating();
        int newTotalReviewCount = store.getTotalReviewCount() + 1;

        // 평균 점수 계산
        double newAverageRating = newTotalRating / newTotalReviewCount;

        if (newAverageRating > 5.0) {
            newAverageRating = 5.0; // 평균 점수가 5를 초과하지 않도록 제한
        } else if (newAverageRating < 0.0) {
            newAverageRating = 0.0; // 평균 점수가 0보다 작아지지 않도록 제한
        }

        // 상점 엔티티에 업데이트된 평균 점수와 리뷰 개수 설정
        store.setTotalRating((long) newTotalRating);
        store.setTotalReviewCount(newTotalReviewCount);
        store.setAverageRating(newAverageRating);

        storeRepository.save(store);
    }
}
