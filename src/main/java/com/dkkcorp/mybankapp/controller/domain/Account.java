package com.dkkcorp.mybankapp.controller.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
@Data
@Entity
class Account {

    @Id
    private Long accountNo;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Float balance;
    @ManyToOne
    private User user;

}
