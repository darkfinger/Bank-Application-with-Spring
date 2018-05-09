package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.TransactionsCommand;
import com.dkkcorp.mybankapp.converter.TransactionToTransactionCommand;
import com.dkkcorp.mybankapp.converter.TransactionsCommandToTransaction;
import com.dkkcorp.mybankapp.domain.Transactions;
import com.dkkcorp.mybankapp.repository.TransactionsRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    TransactionsRepository transactionsRepository;
    TransactionsCommandToTransaction transactionsCommandToTransaction;
    TransactionToTransactionCommand transactionToTransactionCommand;

    public TransactionsServiceImpl(TransactionsRepository transactionsRepository, TransactionsCommandToTransaction transactionsCommandToTransaction, TransactionToTransactionCommand transactionToTransactionCommand) {
        this.transactionsRepository = transactionsRepository;
        this.transactionsCommandToTransaction = transactionsCommandToTransaction;
        this.transactionToTransactionCommand = transactionToTransactionCommand;
    }

    @Nullable
    @Override
    public TransactionsCommand findTransact(Long id) {
        Optional<Transactions> optionalTransactions=transactionsRepository.findById(id);
        if(!optionalTransactions.isPresent()){
            return null;
        }
        return transactionToTransactionCommand.convert(optionalTransactions.get());
    }

    @Override
    public List<TransactionsCommand> findAllTransact() {
        List<TransactionsCommand> transactionsCommandList=new ArrayList<>();
        transactionsRepository.findAll().iterator()
                .forEachRemaining(transactions -> transactionsCommandList.add(transactionToTransactionCommand.convert(transactions)));
        return transactionsCommandList;
    }

    @Override
    public List<TransactionsCommand> findTransactByAccount(Long accountNo) {
        List<TransactionsCommand> list=new ArrayList<>();
        for(TransactionsCommand transactionsCommand:findAllTransact()){
            if((transactionsCommand.getFromAccount().getAccountNo()==accountNo)||(transactionsCommand.getToAccount().getAccountNo()==accountNo)){
                list.add(transactionsCommand);
            }
        }
        return list;
    }

    @Override
    public List<TransactionsCommand> findTransactByUser(Long userId) {
        List<TransactionsCommand> list=new ArrayList<>();
        for(TransactionsCommand transactionsCommand:findAllTransact()){
            if((transactionsCommand.getFromAccount().getUserId()==userId)||(transactionsCommand.getToAccount().getUserId()==userId)){
                list.add(transactionsCommand);
            }
        }
        return list;
    }

    @Override
    public TransactionsCommand saveTransact(Long id) {
        Optional<Transactions> optionalTransactions=transactionsRepository.findById(id);
        if(!optionalTransactions.isPresent()){
            return null;
        }
        return transactionToTransactionCommand.convert(optionalTransactions.get());
    }

    @Override
    public void deleteTransact(Long id) {
        transactionsRepository.deleteById(id);
    }
}
