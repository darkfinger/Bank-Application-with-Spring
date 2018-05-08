package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;

import java.util.List;

public interface AccountService {

    AccountCommand findAccount(Long id);
    List<AccountCommand> findByUserId(Long id);
    List<AccountCommand> findAllAccount();
    AccountCommand saveAccount(AccountCommand accountCommand);
    void deleteAccount(Long id);

}
