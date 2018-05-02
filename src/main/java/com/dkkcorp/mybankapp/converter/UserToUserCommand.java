package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.User;
import jdk.internal.jline.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserToUserCommand implements Converter<User,UserCommand> {

    AccountToAccountCommand accountToAccountCommand;
    UserContactToUserContactCommand userContactToUserContactCommand;
    UserAddressToUserAddressCommand userAddressToUserAddressCommand;



    @Nullable
    @Synchronized
    @Override
    public UserCommand convert(User source) {
        if(source==null){
            return null;
        }
        final UserCommand userCommand=new UserCommand();
        userCommand.setId(source.getId());
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());
        userCommand.setEmail(source.getEmail());
        userCommand.setPassword(source.getPassword());
        userCommand.setPin(source.getPin());
        userCommand.setDateOfBirth(source.getDateOfBirth());
        userCommand.setDateOfSubscription(source.getDateOfSubscription());
        source.getAccount().forEach(accountCommand -> userCommand.getAccount().add(accountToAccountCommand.convert(accountCommand)));
        source.getUserAddress().forEach(userAddressCommand -> userCommand.getUserAddress().add(userAddressToUserAddressCommand.convert(userAddressCommand)));
        source.getUserContact().forEach(userContactCommand -> userCommand.getUserContact().add(userContactToUserContactCommand.convert(userContactCommand)));

        return userCommand;
    }
}
