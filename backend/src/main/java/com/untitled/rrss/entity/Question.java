package com.untitled.rrss.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="question")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="question")
    private String question;

    @Column(name="product_id")
    private String productId;

    @Column(name="merchant_id")
    private String merchantId;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_lastname")
    private String userLastname;


}
