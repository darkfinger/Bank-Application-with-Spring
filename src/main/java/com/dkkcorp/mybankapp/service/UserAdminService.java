package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.UserAdminCommand;

import java.util.List;
import java.util.Optional;

public interface UserAdminService {
    List<UserAdminCommand> findAllAdmin();
    Optional<UserAdminCommand> findAdmin(Long id);
    UserAdminCommand saveAdmin(UserAdminCommand userCommand);
    void deleteAdmin(Long id);

}
