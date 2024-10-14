package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "district", indexes = {
        @Index(name = "idx_city_id", columnList = "city_id")
})
public class District {
    @Id
    @Column(name = "district_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false, referencedColumnName = "district_id")
    private Street street;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

}