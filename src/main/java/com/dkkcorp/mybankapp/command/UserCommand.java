package com.dkkcorp.mybankapp.command;

import com.dkkcorp.mybankapp.domain.UserAddress;
import com.dkkcorp.mybankapp.domain.UserContact;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {
    private Long id;
    private List<AccountCommand> account=new ArrayList<>();
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer pin;
    private Date dateOfBirth;
    private Date dateOfSubscription;
    private List<UserAddressCommand> userAddress=new ArrayList<>();
    private List<UserContactCommand> userContact=new ArrayList<>();
}
