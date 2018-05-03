package com.dkkcorp.mybankapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer pin;
    private Date dateOfBirth;
    @CreationTimestamp
    private Date dateOfSubscription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserAddress> userAddress=new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserContact> userContact=new ArrayList<>();

    public void addAccount(Account account){
        this.getAccount().add(account);
        account.setUser(this);
    }
    public void addAddress(UserAddress userAddress){
        this.getUserAddress().add(userAddress);
        userAddress.setUser(this);
    }
    public void addAcontact(UserContact userContact){
        this.getUserContact().add(userContact);
        userContact.setUser(this);
    }
}
