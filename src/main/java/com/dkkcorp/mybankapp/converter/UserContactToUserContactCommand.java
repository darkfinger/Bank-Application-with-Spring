package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserContactCommand;
import com.dkkcorp.mybankapp.domain.UserContact;
import jdk.internal.jline.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserContactToUserContactCommand implements Converter<UserContact,UserContactCommand> {
    @Synchronized
    @Nullable
    @Override
    public UserContactCommand convert(UserContact source) {
        if(source==null){
            return null;
        }
        final UserContactCommand userContactCommand=new UserContactCommand();
        userContactCommand.setContactNumber(source.getContactNumber());
        userContactCommand.setId(source.getId());
        userContactCommand.setTypeContact(source.getTypeContact());
        userContactCommand.setId(source.getUser().getId());
        return null;
    }
}
