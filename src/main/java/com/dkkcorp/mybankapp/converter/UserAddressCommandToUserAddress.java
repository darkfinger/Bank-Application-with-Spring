package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.UserAddressCommand;
import com.dkkcorp.mybankapp.domain.User;
import com.dkkcorp.mybankapp.domain.UserAddress;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserAddressCommandToUserAddress implements Converter<UserAddressCommand,UserAddress> {

    @Nullable
    @Synchronized
    @Override
    public UserAddress convert(UserAddressCommand source) {

        if (source == null) {
            return null;
        }
        final UserAddress userAddress=new UserAddress();
        userAddress.setCity(source.getCity());
        userAddress.setCountry(source.getCountry());
        userAddress.setId(source.getId());
        userAddress.setNumber(source.getNumber());
        userAddress.setStreet(source.getStreet());
        User user=new User();
        user.setId(source.getUserId());
        userAddress.setUser(user);
        userAddress.setZipCode(source.getZipCode());
        return userAddress;
    }
}
