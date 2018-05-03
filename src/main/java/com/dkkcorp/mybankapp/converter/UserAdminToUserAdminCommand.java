package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.domain.UserAdmin;
import lombok.Synchronized;
import org.springframework.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserAdminToUserAdminCommand implements Converter<UserAdmin,UserAdminCommand> {

    AccountToAccountCommand accountToAccountCommand;
    UserAddressToUserAddressCommand userAddressToUserAddressCommand;
    UserContactToUserContactCommand userContactToUserContactCommand;

    @Nullable
    @Synchronized
    @Override
    public UserAdminCommand convert(UserAdmin source) {
        if(source==null){
            return null;
        }
        final UserAdminCommand userAdminCommand=new UserAdminCommand();
        userAdminCommand.setAdminPassword(source.getAdminPassword());
        userAdminCommand.setPosition(source.getPosition());
        return userAdminCommand;
    }
}
