package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.AccountType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Account {

    @Id
    private Long accountNo;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private Float balance;
    @ManyToOne
    private User user;

}
