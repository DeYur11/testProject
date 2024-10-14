package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "`order`", indexes = {
        @Index(name = "pizzeria_id", columnList = "pizzeria_id"),
        @Index(name = "employee_id", columnList = "employee_id"),
        @Index(name = "status_order_id", columnList = "status_order_id"),
        @Index(name = "payment_id", columnList = "payment_id"),
        @Index(name = "customer_id", columnList = "customer_id")
})
public class Order {
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pizzeria_id", nullable = false)
    private Pizzeria pizzeria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "tracking_number", nullable = false, length = 50)
    private String trackingNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_order_id", nullable = false)
    private StatusOrder statusOrder;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "order_time", nullable = false)
    private Instant orderTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}