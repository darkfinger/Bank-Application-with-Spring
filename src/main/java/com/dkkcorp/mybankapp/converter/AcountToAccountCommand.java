package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.AccountCommand;
import com.dkkcorp.mybankapp.domain.Account;
import jdk.internal.jline.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AcountToAccountCommand implements Converter<Account,AccountCommand> {

    @Synchronized
    @Nullable
    @Override
    public AccountCommand convert(Account source) {
        if(source==null){
            return null;
        }
        final AccountCommand accountCommand=new AccountCommand();
        accountCommand.setAccountNo(source.getAccountNo());
        accountCommand.setAccountType(source.getAccountType());
        accountCommand.setBalance(source.getBalance());
        accountCommand.setUserId(source.getUser().getId());
        return accountCommand;
    }
}
