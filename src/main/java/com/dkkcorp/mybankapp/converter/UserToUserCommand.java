package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.domain.User;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserCommand implements Converter<User,UserCommand> {

    private AccountToAccountCommand accountToAccountCommand;
    private UserContactToUserContactCommand userContactToUserContactCommand;
    private UserAddressToUserAddressCommand userAddressToUserAddressCommand;

    public UserToUserCommand(AccountToAccountCommand accountToAccountCommand, UserContactToUserContactCommand userContactToUserContactCommand, UserAddressToUserAddressCommand userAddressToUserAddressCommand) {
        this.accountToAccountCommand = accountToAccountCommand;
        this.userContactToUserContactCommand = userContactToUserContactCommand;
        this.userAddressToUserAddressCommand = userAddressToUserAddressCommand;
    }

    @Nullable
    @Synchronized
    @Override
    public UserCommand convert(User source) {
        if(source==null){
            return null;
        }
        UserCommand userCommand=new UserCommand();
        userCommand.setId(source.getId());
        userCommand.setFirstName(source.getFirstName());
        userCommand.setLastName(source.getLastName());
        userCommand.setEmail(source.getEmail());
        userCommand.setPassword(source.getPassword());
        userCommand.setPin(source.getPin());
        userCommand.setDateOfBirth(source.getDateOfBirth());
        userCommand.setDateOfSubscription(source.getDateOfSubscription());
        source.getAccount().iterator().forEachRemaining(accountCommand -> userCommand.getAccount().add(accountToAccountCommand.convert(accountCommand)));
        source.getUserAddress().iterator().forEachRemaining(userAddressCommand -> userCommand.getUserAddress().add(userAddressToUserAddressCommand.convert(userAddressCommand)));
        source.getUserContact().iterator().forEachRemaining(userContactCommand -> userCommand.getUserContact().add(userContactToUserContactCommand.convert(userContactCommand)));

        return userCommand;
    }
}
