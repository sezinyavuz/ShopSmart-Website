package com.untitled.rrss.rest;

import com.untitled.rrss.entity.Review;
import com.untitled.rrss.entity.User;
import com.untitled.rrss.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    private ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService theReviewService) {
        reviewService = theReviewService;
    }

    @GetMapping("/review")
    public List<Review> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("review/{theId}")
    public Review findReviewById(@PathVariable int theId){
        return reviewService.findById(theId);
    }

    @GetMapping("/products/{productId}")
    public List<Review> getReviewsByProductId(@PathVariable int productId) {
        return reviewService.findByProductId(productId);
    }

    @PostMapping("/review")
    public Review addReview(@RequestBody Review theReview) {

        theReview.setId(0);

        Review dbReview = reviewService.save(theReview);
        return dbReview;
    }

    /*@PutMapping("/review/{theId}")
    public Review updateReview(@PathVariable int theId, @RequestBody Review theReview) {
        theReview.setId(theId);
        return reviewService.save(theReview);
    }*/

    @PutMapping("/review/{reviewId}")
    public Review updateReview(@PathVariable int reviewId, @RequestBody String reviewString) {

        // String tempString = reviewString.substring(10,-2);
        Review tempReview = reviewService.findById(reviewId);
        tempReview.setReview(reviewString);
        Review dbReview = reviewService.save(tempReview);
        return dbReview;
    }





    @DeleteMapping("/review/{theId}")
    public String deleteReview(@PathVariable int theId){
        Review tempReview = reviewService.findById(theId);

        if (tempReview == null) {
            throw new RuntimeException("Review id not found - " + theId);
        }

        reviewService.deleteById(theId);

        return "Deleted user by id - " + theId;
    }
}
