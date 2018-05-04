package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AdminCommand;

import java.util.List;

public interface UserAdminService {
    List<AdminCommand> findAllAdmin();
    AdminCommand findAdmin(Long id);
    AdminCommand saveAdmin(AdminCommand userCommand);
    void deleteAdmin(Long id);

}
