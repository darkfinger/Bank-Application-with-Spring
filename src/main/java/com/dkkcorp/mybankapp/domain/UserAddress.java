package com.dkkcorp.mybankapp.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(max = 100)
    private String country;
    @NotNull
    @Size(max = 100)
    private String city;
    @NotNull
    @Size(max = 100)
    private String street;
    @Size(max = 100)
    private String number;
    @Size(max = 32)
    @NotNull
    private String zipCode;
    @ManyToOne
    private User user;
}
