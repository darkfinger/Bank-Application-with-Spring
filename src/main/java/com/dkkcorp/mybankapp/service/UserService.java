package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserCommand;

import java.util.List;

public interface UserService {

    UserCommand findUser(Long id);
    List<UserCommand> findAllUser();
    UserCommand saveUser(UserCommand userCommand);
    void deleteUser(Long id);


}
