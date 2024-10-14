package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pizza_type", indexes = {
        @Index(name = "pizza_type_index_0", columnList = "name")
})
public class PizzaType {
    @Id
    @Column(name = "pizza_type_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

}