package com.dkkcorp.mybankapp.controller.domain;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TypeContact typeContact;
    private Integer ContactNumber;
    @ManyToOne
    private User user;
}
