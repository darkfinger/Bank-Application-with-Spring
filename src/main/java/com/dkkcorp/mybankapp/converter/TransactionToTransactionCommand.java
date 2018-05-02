package com.dkkcorp.mybankapp.converter;

import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.domain.Transactions;
import jdk.internal.jline.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class TransactionToTransactionCommand implements Converter<Transactions,TransactionsCommand> {

    AccountToAccountCommand accountToAccountCommand;

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
