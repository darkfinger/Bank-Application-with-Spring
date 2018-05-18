package com.dkkcorp.mybankapp.command;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private List<AccountCommand> account=new ArrayList<>();

    @NotNull
    @Size(max = 65)
    private String firstName;
    @NotNull
    @Size(max = 65)
    private String lastName;
    @NotNull
    @Email
    @Size(max = 100)
    private String email;
    @NotNull
    @Size(min = 8,max = 128)
    private String password;
    @NotNull
    @Size(min = 4,max = 12)
    private Integer pin;
    @NotNull
    @Temporal(TemporalType.DATE)
    private String dateOfBirth;
    @Temporal(TemporalType.DATE)
    private Date dateOfSubscription;
    private List<UserAddressCommand> userAddress=new ArrayList<>();
    private List<UserContactCommand> userContact=new ArrayList<>();

    public void addAccount(AccountCommand account){
        this.getAccount().add(account);
        account.setUserId(this.id);
    }
    public void addAddress(UserAddressCommand userAddress){
        this.getUserAddress().add(userAddress);
        userAddress.setUserId(this.id);
    }
    public void addContact(UserContactCommand userContact){
        this.getUserContact().add(userContact);
        userContact.setUserId(this.id);
    }
}
