package com.dkkcorp.mybankapp.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
@Data
@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 8,max = 20)
    @OneToOne(fetch = FetchType.EAGER)
    private Account fromAccount;

    @NotNull
    @Size(min = 8,max = 20)
    @OneToOne(fetch = FetchType.EAGER)
    private Account toAccount;

    @CreationTimestamp
    private Date dateOfTransaction;

    @NotNull
    @Size(max = 20)
    private Float amount;
}
