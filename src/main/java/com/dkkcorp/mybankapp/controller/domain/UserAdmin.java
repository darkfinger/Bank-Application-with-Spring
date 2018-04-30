package com.dkkcorp.mybankapp.controller.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class UserAdmin extends User {

    private String adminPassword;
    private String position;
}
