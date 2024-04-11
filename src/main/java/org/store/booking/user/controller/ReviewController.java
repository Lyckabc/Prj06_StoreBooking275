package org.store.booking.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.store.booking.user.domain.dto.ReviewDto;
import org.store.booking.user.service.ReviewService;

import javax.servlet.http.HttpServletRequest;

/****************************************************
 **                                                 **
 **        Prj06_StoreBooking275                          **
 **        ReviewController                                  **
 **        Made by dong-hoshin                          **
 **        4/8/24 :18:26                         **
 **        https://github.com/lyckabc               **
 **                                                 **
 ****************************************************/

@Api(tags = "리뷰 컨트롤러")
@RestController
@RequestMapping("/shop/v1/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @ApiOperation(value = "리뷰 작성", notes = "손님이 자신이 이용한 상점에 대해 리뷰를 남길 수 있게 합니다.")
    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@RequestBody ReviewDto reviewDto, HttpServletRequest request) {
        reviewService.createReview(reviewDto, request);
        return ResponseEntity.ok("review create success!");

    }
}
