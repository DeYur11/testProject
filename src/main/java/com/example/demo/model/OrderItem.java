package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_item", indexes = {
        @Index(name = "order_id", columnList = "order_id"),
        @Index(name = "custom_pizza_id", columnList = "custom_pizza_id")
})
public class OrderItem {
    @Id
    @Column(name = "order_item_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "custom_pizza_id", nullable = false)
    private CustomPizza customPizza;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}