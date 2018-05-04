package com.dkkcorp.mybankapp.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String street;
    private String number;
    private String zipCode;
    @ManyToOne
    private User user;
}
