package com.untitled.rrss.service;

import com.untitled.rrss.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();

    Review findById(int theId);

    Review findByMerchantId(int theMerchantId);

    Review findByReviewerName(String reviewerName, String reviewerSurname);

    List<Review> findByProductId(int theProductId);

    Review save(Review theReview);

    void deleteById(int theId);


}
