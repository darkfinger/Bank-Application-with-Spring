package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.domain.UserAdmin;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAdminCommandToUserAdmin implements Converter<UserAdminCommand,UserAdmin> {

    AccountCommandToAccount accountCommandToAccount;
    UserAddressCommandToUserAddress userAddressCommandToUserAddress;
    UserContactCommandToUserContact userContactCommandToUserContact;

    public UserAdminCommandToUserAdmin(AccountCommandToAccount accountCommandToAccount, UserAddressCommandToUserAddress userAddressCommandToUserAddress, UserContactCommandToUserContact userContactCommandToUserContact) {
        this.accountCommandToAccount = accountCommandToAccount;
        this.userAddressCommandToUserAddress = userAddressCommandToUserAddress;
        this.userContactCommandToUserContact = userContactCommandToUserContact;
    }

    @Synchronized
    @Nullable
    @Override
    public UserAdmin convert(UserAdminCommand source) {
        if(source==null){
            return null;
        }
        final UserAdmin userAdmin=new UserAdmin();
        userAdmin.setAdminPassword(source.getAdminPassword());
        userAdmin.setPosition(source.getPosition());
        return userAdmin;
    }
}
