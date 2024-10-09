package com.untitled.rrss.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="product_name")
    private String productName;


    @Column(name="category")
    private String category;

    @Column(name="rating")
    private float rating;

    @Column(name="seller")
    private String seller;

    @Column(name="price")
    private float price;

    @Column(name="image_url")
    private String imageUrl;

    public Product(String productName, String category, float rating, String seller, float price, String imageUrl) {
        this.productName = productName;
        this.category = category;
        this.rating = rating;
        this.seller = seller;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
