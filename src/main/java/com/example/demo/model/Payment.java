package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @Column(name = "payment_status_id")
    private Integer paymentStatusId;

    @Column(name = "payment_method_id")
    private Integer paymentMethodId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_number", nullable = false, length = 50)
    private String transactionNumber;

    @Column(name = "order_id")
    private Integer orderId;

}