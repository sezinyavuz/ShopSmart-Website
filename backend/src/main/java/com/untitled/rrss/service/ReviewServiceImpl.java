package com.untitled.rrss.service;

import com.untitled.rrss.dao.ReviewDAO;
import com.untitled.rrss.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewDAO reviewDAO;

    @Autowired
    public ReviewServiceImpl(ReviewDAO theReviewDAO) {
        reviewDAO = theReviewDAO;
    }

    @Override
    public List<Review> findAll() {
        return reviewDAO.findAll();
    }

    @Override
    public Review findById(int theId) {
        return reviewDAO.findById(theId);
    }

    @Override
    public Review findByMerchantId(int theMerchantId) {
        return null;
    }

    @Override
    public Review findByReviewerName(String reviewerName, String reviewerSurname) {
        return null;
    }

    @Override
    public List<Review> findByProductId(int theProductId) {
        return reviewDAO.findByProductId(theProductId);
    }

    @Transactional
    @Override
    public Review save(Review theReview) {
        return reviewDAO.save(theReview);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        reviewDAO.deleteById(theId);
    }
}
