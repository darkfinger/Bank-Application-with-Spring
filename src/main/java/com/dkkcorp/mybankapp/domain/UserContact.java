package com.dkkcorp.mybankapp.domain;

import com.dkkcorp.mybankapp.domain.enums.TypeContact;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeContact typeContact;
    @Size(max = 15)
    private Integer ContactNumber;
    @ManyToOne
    private User user;
}
