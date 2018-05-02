package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.domain.Account;
import jdk.internal.jline.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountCommandToAccount implements Converter<AccountCommand, Account> {

    UserCommandToUser userCommandToUser;

    public AccountCommandToAccount(UserCommandToUser userCommandToUser) {
        this.userCommandToUser = userCommandToUser;
    }

    @Synchronized
    @Nullable
    @Override
    public Account convert(AccountCommand source) {
        if(source==null){
            return null;
        }
        final Account account=new Account();
        account.setAccountNo(source.getAccountNo());
        account.setAccountType(source.getAccountType());
        account.setBalance(source.getBalance());
        account.getUser().setId(source.getUserId());
        return account;
    }
}
