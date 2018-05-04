package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.converter.UserAdminCommandToUserAdmin;
import com.dkkcorp.mybankapp.converter.UserAdminToUserAdminCommand;
import com.dkkcorp.mybankapp.domain.User;
import com.dkkcorp.mybankapp.domain.UserAdmin;
import com.dkkcorp.mybankapp.repository.UserAdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    UserAdminRepository userAdminRepository;
    UserService userService;
    UserAdminToUserAdminCommand userAdminToUserAdminCommand;
    UserAdminCommandToUserAdmin userAdminCommandToUserAdmin;

    public UserAdminServiceImpl(UserAdminRepository userAdminRepository, UserService userRepository, UserAdminToUserAdminCommand userAdminToUserAdminCommand, UserAdminCommandToUserAdmin userAdminCommandToUserAdmin) {
        this.userAdminRepository = userAdminRepository;
        this.userService = userRepository;
        this.userAdminToUserAdminCommand = userAdminToUserAdminCommand;
        this.userAdminCommandToUserAdmin = userAdminCommandToUserAdmin;
    }

    @Override
    public UserAdminCommand saveAdmin(UserAdminCommand userAdminCommand) {
        UserAdmin userAdmin=userAdminCommandToUserAdmin.convert(userAdminCommand);
        UserAdmin userAdminSeved=userAdminRepository.save(userAdmin);
        return new UserAdminCommand();
    }
}
