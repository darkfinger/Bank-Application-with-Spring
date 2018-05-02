package com.dkkcorp.mybankapp;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.domain.Account;
import com.dkkcorp.mybankapp.domain.UserAdmin;
import com.dkkcorp.mybankapp.domain.enums.Positions;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UserAdminCommand user1=new UserAdminCommand();
        user1.setPosition(Positions.MANAGER);
        user1.setAdminPassword("123456789");
        user1.getAccount().add(new AccountCommand());
        user1

    }
}
