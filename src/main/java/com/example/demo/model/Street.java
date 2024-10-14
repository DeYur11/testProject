package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "street", indexes = {
        @Index(name = "idx_district_id", columnList = "district_id")
})
public class Street {
    @Id
    @Column(name = "street_id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "street_id", nullable = false, referencedColumnName = "street_id")
    private Pizzeria pizzeria;

    @Column(name = "district_id", nullable = false)
    private Integer districtId;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

}