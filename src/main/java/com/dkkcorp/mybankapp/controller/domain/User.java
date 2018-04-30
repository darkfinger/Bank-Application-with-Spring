package com.dkkcorp.mybankapp.controller.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountNo;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer pin;
    private Date dateOfBirth;
    private Date dateOfSubscription;
    private List<UserAddress> userAddress=new ArrayList<>();
    private List<UserContact> userContact=new ArrayList<>();

}
