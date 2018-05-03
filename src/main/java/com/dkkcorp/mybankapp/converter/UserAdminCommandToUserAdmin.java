package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.domain.UserAdmin;
import org.springframework.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class UserAdminCommandToUserAdmin implements Converter<UserAdminCommand,UserAdmin> {

    AccountCommandToAccount accountCommandToAccount;
    UserAddressCommandToUserAddress userAddressCommandToUserAddress;
    UserContactCommandToUserContact userContactCommandToUserContact;

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
        userAdmin.setId(source.getId());
        userAdmin.setFirstName(source.getFirstName());
        userAdmin.setLastName(source.getLastName());
        userAdmin.setEmail(source.getEmail());
        userAdmin.setPassword(source.getPassword());
        userAdmin.setPin(source.getPin());
        userAdmin.setDateOfBirth(source.getDateOfBirth());
        userAdmin.setDateOfSubscription(source.getDateOfSubscription());
        source.getAccount().forEach(accountCommand -> userAdmin.getAccount().add(accountCommandToAccount.convert(accountCommand)));
        source.getUserAddress().forEach(userAddressCommand -> userAdmin.getUserAddress().add(userAddressCommandToUserAddress.convert(userAddressCommand)));
        source.getUserContact().forEach(userContactCommand -> userAdmin.getUserContact().add(userContactCommandToUserContact.convert(userContactCommand)));

        return userAdmin;
    }
}
