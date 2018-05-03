package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.converter.UserAdminCommandToUserAdmin;
import com.dkkcorp.mybankapp.converter.UserAdminToUserAdminCommand;
import com.dkkcorp.mybankapp.domain.UserAdmin;
import com.dkkcorp.mybankapp.repository.UserAdminRepository;
import org.springframework.stereotype.Service;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    UserAdminRepository userAdminRepository;
    UserAdminToUserAdminCommand userAdminToUserAdminCommand;
    UserAdminCommandToUserAdmin userAdminCommandToUserAdmin;

    public UserAdminServiceImpl(UserAdminRepository userAdminRepository, UserAdminToUserAdminCommand userAdminToUserAdminCommand, UserAdminCommandToUserAdmin userAdminCommandToUserAdmin) {
        this.userAdminRepository = userAdminRepository;
        this.userAdminToUserAdminCommand = userAdminToUserAdminCommand;
        this.userAdminCommandToUserAdmin = userAdminCommandToUserAdmin;
    }

    @Override
    public UserAdminCommand saveAdmin(UserAdminCommand userAdminCommand) {
        UserAdmin userAmin=userAdminCommandToUserAdmin.convert(userAdminCommand);
        System.out.println("after conversion : "+userAmin.getFirstName()+"*********************************************************************************");
        userAmin=userAdminRepository.save(userAmin);
        return userAdminToUserAdminCommand.convert(userAmin);
    }
}
