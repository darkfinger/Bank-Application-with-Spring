package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.converter.AccountCommandToAccount;
import com.dkkcorp.mybankapp.converter.AccountToAccountCommand;
import com.dkkcorp.mybankapp.domain.Account;
import com.dkkcorp.mybankapp.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    AccountRepository accountRepository;
    AccountToAccountCommand accountToAccountCommand;
    AccountCommandToAccount accountCommandToAccount;

    public AccountServiceImpl(AccountRepository accountRepository, AccountToAccountCommand accountToAccountCommand, AccountCommandToAccount accountCommandToAccount) {
        this.accountRepository = accountRepository;
        this.accountToAccountCommand = accountToAccountCommand;
        this.accountCommandToAccount = accountCommandToAccount;
    }

    @Override
    public AccountCommand findAccount(Long id) {
        Optional<Account> optionalAccount=accountRepository.findById(id);
        if(!optionalAccount.isPresent()){
            throw new RuntimeException("Can't find an account associated to this id");
        }
        return accountToAccountCommand.convert(optionalAccount.get());
    }

    @Override
    public List<AccountCommand> findByUserId(Long id) {
        List<AccountCommand> list=new ArrayList<>();
        for(AccountCommand account:findAllAccount()){
            if(account.getUserId()==id){
                list.add(account);
            }
        }
        return list;
    }


    @Override
    public List<AccountCommand> findAllAccount() {
        List<AccountCommand> list=new ArrayList<>();
        accountRepository.findAll().iterator().forEachRemaining(account -> list.add(accountToAccountCommand.convert(account)));
        return list;
    }

    @Override
    public AccountCommand saveAccount(AccountCommand accountCommand) {
        Account account=accountCommandToAccount.convert(accountCommand);
        account=accountRepository.save(account);
        return accountToAccountCommand.convert(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
