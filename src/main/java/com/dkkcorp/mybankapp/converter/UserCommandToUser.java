package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    private AccountCommandToAccount accountCommandToAccount;
    private UserAddressCommandToUserAddress userAddressCommandToUserAddress;
    private UserContactCommandToUserContact userContactCommandToUserContact;

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
        Date date1= null;
        try {
            date1 = new SimpleDateFormat("yyyy-dd-MM").parse(source.getDateOfBirth());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setDateOfBirth(date1);
        user.setDateOfSubscription(source.getDateOfSubscription());
        source.getAccount().forEach(accountCommand -> user.addAccount(accountCommandToAccount.convert(accountCommand)));
        source.getUserAddress().forEach(userAddressCommand -> user.addAddress(userAddressCommandToUserAddress.convert(userAddressCommand)));
        source.getUserContact().forEach(userContactCommand -> user.addContact(userContactCommandToUserContact.convert(userContactCommand)));
        return user;
    }
}
