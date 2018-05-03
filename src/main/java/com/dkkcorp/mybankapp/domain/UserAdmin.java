package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
public class UserAdmin extends User {

    private String adminPassword;
    @Enumerated(EnumType.STRING)
    private Positions position;
}
