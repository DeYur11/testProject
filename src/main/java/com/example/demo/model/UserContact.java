package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_contact", indexes = {
        @Index(name = "contact_type_id", columnList = "contact_type_id"),
        @Index(name = "user_id", columnList = "user_id")
})
public class UserContact {
    @Id
    @Column(name = "user_contact_id", nullable = false)
    private Integer id;

    @Column(name = "contact_value", nullable = false, length = 50)
    private String contactValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_type_id", nullable = false)
    private ContactType contactType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}