package com.dkkcorp.mybankapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Account> account=new ArrayList<>();

    @NotNull
    @Size(max = 65)
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Size(max = 65)
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;
    @NotNull
    @Size(min = 8,max = 128)
    private String password;
    @NotNull
    @Size(min = 4,max = 12)
    private Integer pin;
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date dateOfSubscription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserAddress> userAddress=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserContact> userContact=new ArrayList<>();

}
