package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.AdminCommand;
import com.dkkcorp.mybankapp.domain.Admin;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminCommandToAdmin implements Converter<AdminCommand,Admin> {

    @Synchronized
    @Nullable
    @Override
    public Admin convert(AdminCommand source) {
        if(source==null){
            return null;
        }
        final Admin admin =new Admin();
        admin.setId(source.getId());
        admin.setAdminPassword(source.getAdminPassword());
        admin.setPosition(source.getPosition());
        admin.setAdminEmail(source.getAdminEmail());
        admin.setLastLogin(source.getLastLogin());
        return admin;
    }
}
