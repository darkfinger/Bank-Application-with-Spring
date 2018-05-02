package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserContactCommand;
import com.dkkcorp.mybankapp.domain.UserContact;
import jdk.internal.jline.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserContactCommandToUserContact implements Converter<UserContactCommand,UserContact> {

    @Synchronized
    @Nullable
    @Override
    public UserContact convert(UserContactCommand source) {
        if (source == null) {
            return null;
        }
        final UserContact userContact=new UserContact();
        userContact.setContactNumber(source.getContactNumber());
        userContact.setId(source.getId());
        userContact.setTypeContact(source.getTypeContact());
        userContact.getUser().setId(source.getId());
        return userContact;
    }
}