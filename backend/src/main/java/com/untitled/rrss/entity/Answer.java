package com.untitled.rrss.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="answer")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Answer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="answer")
    private String answer;

    @Column(name="product_id")
    private String productId;

    @Column(name="merchant_id")
    private String merchantId;

    @Column(name="question_id")
    private String questionId;

    @Column(name="merchant_name")
    private String merchantName;


}
