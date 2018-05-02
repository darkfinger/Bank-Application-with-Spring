package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.converter.AccountCommandToAccount;
import com.dkkcorp.mybankapp.converter.AccountToAccountCommand;
import com.dkkcorp.mybankapp.domain.Account;
import com.dkkcorp.mybankapp.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    AccountToAccountCommand accountToAccountCommand;
    AccountCommandToAccount accountCommandToAccount;
    @Override
    public Account saveAccount(AccountCommand accountCommand) {
        Account account=accountCommandToAccount.convert(accountCommand);
        account=accountRepository.save(account);

        return account;
    }
}
