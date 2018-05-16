package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.command.AdminCommand;
import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.command.UserCommand;

import java.util.List;

public interface AdminService {
    List<AdminCommand> findAllAdmin();
    AdminCommand findAdmin(Long id);
    AdminCommand saveAdmin(AdminCommand userCommand);
    void deleteAdmin(Long id);

    List<UserCommand> findAllUser();
    List<AccountCommand> findAllAccount();


}
