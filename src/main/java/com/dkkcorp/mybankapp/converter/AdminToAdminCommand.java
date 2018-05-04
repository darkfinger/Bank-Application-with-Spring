package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.AdminCommand;
import com.dkkcorp.mybankapp.domain.Admin;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AdminToAdminCommand implements Converter<Admin,AdminCommand> {

    AccountToAccountCommand accountToAccountCommand;
    UserAddressToUserAddressCommand userAddressToUserAddressCommand;
    UserContactToUserContactCommand userContactToUserContactCommand;

    @Nullable
    @Synchronized
    @Override
    public AdminCommand convert(Admin source) {
        if(source==null){
            return null;
        }
        final AdminCommand adminCommand =new AdminCommand();
        adminCommand.setAdminPassword(source.getAdminPassword());
        adminCommand.setPosition(source.getPosition());
        adminCommand.setId(source.getId());
        adminCommand.setAdminEmail(source.getAdminEmail());
        adminCommand.setLastLogin(source.getLastLogin());
        return adminCommand;
    }
}
