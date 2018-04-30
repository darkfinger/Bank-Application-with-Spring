package com.dkkcorp.mybankapp.controller.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Account fromAccount;
    @OneToOne(fetch = FetchType.EAGER)
    private Account toAccount;
    @CreationTimestamp
    private Date dateOfTransaction;
    private Float amount;
}
