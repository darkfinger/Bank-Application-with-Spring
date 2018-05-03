package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserAdminCommand;
import com.dkkcorp.mybankapp.command.UserCommand;

public interface UserAdminService {

    UserAdminCommand saveAdmin(UserAdminCommand userCommand);

}
