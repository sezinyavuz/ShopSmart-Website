package com.untitled.rrss.dao;

import com.untitled.rrss.entity.Review;
import com.untitled.rrss.entity.User;

import java.util.List;

public interface ReviewDAO {

    List<Review> findAll();

    Review findById(int theId);

    Review findByMerchantId(int theMerchantId);

    Review findByReviewerName(String reviewerName, String reviewerSurname);

    List<Review> findByProductId(int theProductId);

    Review save(Review theReview);

    void deleteById(int theId);



}
