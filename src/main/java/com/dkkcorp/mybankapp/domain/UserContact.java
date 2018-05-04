package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.TypeContact;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeContact typeContact;
    private Long ContactNumber;
    @ManyToOne
    private User user;
}
