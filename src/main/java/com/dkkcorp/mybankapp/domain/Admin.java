package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String adminEmail;
    private String adminPassword;
    @Enumerated(EnumType.STRING)
    private Positions position;
    @UpdateTimestamp
    private Date lastLogin;
}
