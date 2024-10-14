package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "review", indexes = {
        @Index(name = "customer_id", columnList = "customer_id"),
        @Index(name = "menu_item_id", columnList = "menu_item_id")
})
public class Review {
    @Id
    @Column(name = "review_id", nullable = false)
    private Integer id;

    @Column(name = "message", length = 50)
    private String message;

    @Column(name = "rating", nullable = false)
    private Byte rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

}