package com.dkkcorp.mybankapp.controller.domain;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    private Long accountNo;
    private AccountType accountType;
    private Float balance;

}
