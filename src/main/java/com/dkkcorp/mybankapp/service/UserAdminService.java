package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserCommand;
import com.dkkcorp.mybankapp.converter.UserCommandToUser;
import com.dkkcorp.mybankapp.converter.UserToUserCommand;
import com.dkkcorp.mybankapp.repository.UserRepository;

public interface UserAdminService {
//    UserRepository userRepository;
//    UserCommandToUser userCommandToUser;
//    UserToUserCommand userToUserCommand;
    UserCommand saveAdmin(UserCommand userCommand);
}
