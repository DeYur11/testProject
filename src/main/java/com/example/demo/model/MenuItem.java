package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "menu_item", indexes = {
        @Index(name = "pizza_id", columnList = "pizza_id")
})
public class MenuItem {
    @Id
    @Column(name = "menu_item_id", nullable = false)
    private Integer id;

    @Column(name = "image_file_name", nullable = false, length = 50)
    private String imageFileName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pizza_id", nullable = false)
    private BasePizza pizza;

}