package com.untitled.rrss.dao;

import com.untitled.rrss.entity.Product;
import com.untitled.rrss.entity.Review;
import com.untitled.rrss.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

    private EntityManager entityManager;

    @Autowired
    public ReviewDAOImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Review> findAll() {
        TypedQuery<Review> theQuery = entityManager.createQuery("FROM Review", Review.class);

        List<Review> reviews = theQuery.getResultList();

        return reviews;
    }

    @Override
    public Review findById(int theId) {
        Review review = entityManager.find(Review.class, theId);
        return review;
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
        TypedQuery<Review> query = entityManager.createQuery("SELECT u FROM Review u WHERE u.productId = :theProductId", Review.class);
        query.setParameter("theProductId", theProductId);
        return query.getResultList();
    }

    @Override
    public Review save(Review theReview) {
        Review dbReview = entityManager.merge(theReview);
        return dbReview;
    }



    @Override
    public void deleteById(int theId) {
        Review theReview = entityManager.find(Review.class, theId);

        entityManager.remove(theReview);
    }

}
