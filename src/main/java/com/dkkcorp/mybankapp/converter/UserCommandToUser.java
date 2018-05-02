package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    AccountCommandToAccount accountCommandToAccount;
    UserAddressCommandToUserAddress userAddressCommandToUserAddress;
    UserContactCommandToUserContact userContactCommandToUserContact;

    public UserCommandToUser(AccountCommandToAccount accountCommandToAccount, UserAddressCommandToUserAddress userAddressCommandToUserAddress, UserContactCommandToUserContact userContactCommandToUserContact) {
        this.accountCommandToAccount = accountCommandToAccount;
        this.userAddressCommandToUserAddress = userAddressCommandToUserAddress;
        this.userContactCommandToUserContact = userContactCommandToUserContact;
    }

    @Synchronized
    @Nullable
    @Override
    public User convert(UserCommand source) {
        if (source == null) {
            return null;
        }
        final  User user=new User();
        user.setId(source.getId());
        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setEmail(source.getEmail());
        user.setPassword(source.getPassword());
        user.setPin(source.getPin());
        user.setDateOfBirth(source.getDateOfBirth());
        user.setDateOfSubscription(source.getDateOfSubscription());
        source.getAccount().forEach(accountCommand -> user.getAccount().add(accountCommandToAccount.convert(accountCommand)));
        source.getUserAddress().forEach(userAddressCommand -> user.getUserAddress().add(userAddressCommandToUserAddress.convert(userAddressCommand)));
        source.getUserContact().forEach(userContactCommand -> user.getUserContact().add(userContactCommandToUserContact.convert(userContactCommand)));

        return user;
    }
}