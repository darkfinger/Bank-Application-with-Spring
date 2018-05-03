package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserCommand;

public interface UserService {

    UserCommand saveUser(UserCommand userCommand);
}
