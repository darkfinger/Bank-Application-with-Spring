package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.AccountType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
class Account {

    @Id
    @NotNull
    @Size(min = 8,max = 20)
    private Long accountNo;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Size(max = 15)
    private Float balance;
    @ManyToOne
    private User user;

}
