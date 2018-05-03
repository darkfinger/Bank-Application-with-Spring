package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.domain.Account;
import com.dkkcorp.mybankapp.domain.User;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountCommandToAccount implements Converter<AccountCommand, Account> {

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
        User user=new User();
        user.setId(source.getUserId());
        account.setUser(user);
        return account;
    }
}
