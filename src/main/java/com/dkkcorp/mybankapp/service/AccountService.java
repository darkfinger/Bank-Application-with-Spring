package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.domain.Account;

import java.util.Optional;

public interface AccountService {

    Account saveAccount(AccountCommand accountCommand);

}
