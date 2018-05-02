package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.domain.Transactions;
import jdk.internal.jline.internal.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionsCommandToTransaction implements Converter<TransactionsCommand, Transactions> {

    AccountCommandToAccount accountCommandToAccount;

    public TransactionsCommandToTransaction(AccountCommandToAccount accountCommandToAccount) {
        this.accountCommandToAccount = accountCommandToAccount;
    }

    @Nullable
    @Synchronized
    @Override
    public Transactions convert(TransactionsCommand source) {
        if(source==null){
            return null;
        }
        final Transactions transactions=new Transactions();
        transactions.setAmount(source.getAmount());
        transactions.setId(source.getId());
        transactions.setDateOfTransaction(source.getDateOfTransaction());
        transactions.setFromAccount(accountCommandToAccount.convert(source.getFromAccount()));
        transactions.setToAccount(accountCommandToAccount.convert(source.getToAccount()));
        return transactions;
    }
}
