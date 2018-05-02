package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserAddressCommand;
import com.dkkcorp.mybankapp.domain.UserAddress;
import jdk.internal.jline.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAddressToUserAddressCommand implements Converter<UserAddress,UserAddressCommand> {

    @Synchronized
    @Nullable
    @Override
    public UserAddressCommand convert(UserAddress source) {
        if(source==null){
            return null;
        }
        UserAddressCommand userAddressCommand=new UserAddressCommand();
        userAddressCommand.setCity(source.getCity());
        userAddressCommand.setCountry(source.getCountry());
        userAddressCommand.setId(source.getId());
        userAddressCommand.setNumber(source.getNumber());
        userAddressCommand.setStreet(source.getStreet());
        userAddressCommand.setId(source.getUser().getId());
        userAddressCommand.setZipCode(source.getZipCode());
        return userAddressCommand;
    }
}
