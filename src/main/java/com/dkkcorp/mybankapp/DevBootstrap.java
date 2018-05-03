package com.dkkcorp.mybankapp;

import com.dkkcorp.mybankapp.command.*;
import com.dkkcorp.mybankapp.domain.enums.AccountType;
import com.dkkcorp.mybankapp.domain.enums.Positions;
import com.dkkcorp.mybankapp.domain.enums.TypeContact;
import com.dkkcorp.mybankapp.service.AccountService;
import com.dkkcorp.mybankapp.service.UserAddressService;
import com.dkkcorp.mybankapp.service.UserContactService;
import com.dkkcorp.mybankapp.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;



@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    UserService userService;
    AccountService accountService;
    UserAddressService userAddressService;
    UserContactService userContactService;

    public DevBootstrap(UserService userService, AccountService accountService, UserAddressService userAddressService, UserContactService userContactService) {
        this.userService = userService;
        this.accountService = accountService;
        this.userAddressService = userAddressService;
        this.userContactService = userContactService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UserCommand userCommand=init();
        System.out.println("Return of ini : "+userCommand.getAccount()+"*******************************************************************");
        UserCommand userSaved =userService.saveUser(userCommand);
        System.out.println(userSaved.getAccount()+"*******************************************************************");
    }

    private UserCommand init(){
        //setting Address
        UserAddressCommand userAddressCommand=new UserAddressCommand();
        userAddressCommand.setCountry("Canada");
        userAddressCommand.setCity("Montreal");
        userAddressCommand.setStreet("Berri");
        userAddressCommand.setNumber("57B");
        userAddressCommand.setZipCode("K6K0B5");


        //Setting the contact
        UserContactCommand userContactCommand= new UserContactCommand();
        userContactCommand.setContactNumber(new Long("5149699495"));
        userContactCommand.setTypeContact(TypeContact.DOMICILE);

        //setting an Account
        AccountCommand accountCommand=new AccountCommand();
        accountCommand.setAccountNo(new Long(123456789));
        accountCommand.setAccountType(AccountType.CHECKING);
        accountCommand.setBalance(new Float(100));

        //setting an user
        UserAdminCommand user1=new UserAdminCommand();
        user1.setId(new Long("1"));
        user1.getAccount().add(accountCommand);
        user1.setFirstName("root");
        user1.setLastName("sample");
        user1.setEmail("dav@gm.com");
        user1.setAdminPassword("123456789");
        user1.setPin(1234);
        user1.setDateOfBirth(new Date());
        user1.setDateOfSubscription(java.sql.Date.valueOf(LocalDate.now()));
        user1.setPosition(Positions.MANAGER);
        user1.getUserAddress().add(userAddressCommand);
        user1.getUserContact().add(userContactCommand);

        return user1;
    }
}