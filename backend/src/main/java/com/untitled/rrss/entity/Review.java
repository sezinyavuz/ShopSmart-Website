package com.untitled.rrss.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="review")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_id")
    private int productId;

    @Column(name="merchant_id")
    private int merchantId;

    @Column(name="reviewer_name")
    private String reviewerName;

    @Column(name="reviewer_surname")
    private String reviewerSurname;

    @Column(name="review")
    private String review;

    @Column(name="rating")
    private float rating;

    public Review(int productId, int merchantId, String reviewerName, String reviewerSurname, String review, float rating) {
        this.productId = productId;
        this.merchantId = merchantId;
        this.reviewerName = reviewerName;
        this.reviewerSurname = reviewerSurname;
        this.review = review;
        this.rating = rating;
    }
}
