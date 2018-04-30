package com.dkkcorp.mybankapp.controller.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Account fromAccount;
    private Account toAccount;
    private Date dateOfTransaction;
    private Float amount;
}
