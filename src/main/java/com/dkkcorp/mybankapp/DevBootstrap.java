package com.dkkcorp.mybankapp;

import com.dkkcorp.mybankapp.command.*;
import com.dkkcorp.mybankapp.domain.enums.AccountType;
import com.dkkcorp.mybankapp.domain.enums.Positions;
import com.dkkcorp.mybankapp.domain.enums.TypeContact;
import com.dkkcorp.mybankapp.service.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private AdminService adminService;

    public DevBootstrap(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        adminService.saveAdmin(initAdmin());
        userService.saveUser(initUser());
    }

    public void tryIt() {
//        adminService.saveAdmin(initAdmin());
//        UserCommand userCommand=initUser();
//        System.out.println(userCommand.getUserContact().get(0).getContactNumber()+"before saved **************************************************************");
//        userCommand=userService.saveUser(userCommand);
//        System.out.println(userCommand.getUserContact().get(0).getContactNumber()+"after saved **************************************************************");

    }

    private UserCommand initUser(){
        //setting Address
        UserAddressCommand userAddressCommand=new UserAddressCommand();
        userAddressCommand.setCountry("Canada");
        userAddressCommand.setCity("Montreal");
        userAddressCommand.setStreet("Berri");
        userAddressCommand.setNumber("57B");
        userAddressCommand.setZipCode("K6K0B5");


        //Setting the contact
        UserContactCommand userContactCommand= new UserContactCommand();
        userContactCommand.setContactNumber(5149699495L);
        userContactCommand.setTypeContact(TypeContact.DOMICILE);

        //setting an Account
        AccountCommand accountCommand=new AccountCommand();
        accountCommand.setAccountNo(123456789L);
        accountCommand.setAccountType(AccountType.CHECKING);
        accountCommand.setBalance(100F);

        //setting an user
        UserCommand user1=new UserCommand();
        user1.addAccount(accountCommand);
        user1.setFirstName("Root");
        user1.setLastName("Sample");
        user1.setEmail("dav@gm.com");
        user1.setPassword("123456789");
        user1.setPin(1234);
        user1.setDateOfBirth(new Date());
        user1.addAddress(userAddressCommand);
        user1.addContact(userContactCommand);

        return user1;
    }
    private AdminCommand initAdmin(){
        AdminCommand adminCommand=new AdminCommand();
        adminCommand.setAdminEmail("david@admin.com");
        adminCommand.setAdminPassword("12345600");
        adminCommand.setPosition(Positions.CUSTOMER_SERVICE);
        return adminCommand;
    }
}