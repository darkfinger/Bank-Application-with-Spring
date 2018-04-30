package com.dkkcorp.mybankapp.controller.domain;

import javax.persistence.Entity;

@Entity
public class UserAddress {

    private String country;
    private String city;
    private String street;
    private String number;
    private String zipCode;
}
