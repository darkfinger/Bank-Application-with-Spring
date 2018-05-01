package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class UserAdmin extends User {

    @NotNull
    @Size(min = 8,max = 128)
    private String adminPassword;
    @Enumerated(EnumType.STRING)
    private Positions position;
}
