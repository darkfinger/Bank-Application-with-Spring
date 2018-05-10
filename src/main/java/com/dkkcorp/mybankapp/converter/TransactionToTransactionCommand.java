package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.domain.Transactions;
import org.springframework.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionToTransactionCommand implements Converter<Transactions,TransactionsCommand> {

    private AccountToAccountCommand accountToAccountCommand;

    public TransactionToTransactionCommand(AccountToAccountCommand accountToAccountCommand) {
        this.accountToAccountCommand = accountToAccountCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public TransactionsCommand convert(Transactions source) {
        if(source==null){
            return null;
        }
        final TransactionsCommand transactionsCommand=new TransactionsCommand();
        transactionsCommand.setAmount(source.getAmount());
        transactionsCommand.setId(source.getId());
        transactionsCommand.setDateOfTransaction(source.getDateOfTransaction());
        transactionsCommand.setFromAccount(accountToAccountCommand.convert(source.getFromAccount()));
        transactionsCommand.setToAccount(accountToAccountCommand.convert(source.getToAccount()));
        return transactionsCommand;
    }
}
