package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.AccountCommand;
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

    AccountService accountService;
    TransactionsRepository transactionsRepository;
    TransactionsCommandToTransaction transactionsCommandToTransaction;
    TransactionToTransactionCommand transactionToTransactionCommand;

    public TransactionsServiceImpl(AccountService accountService,TransactionsRepository transactionsRepository, TransactionsCommandToTransaction transactionsCommandToTransaction, TransactionToTransactionCommand transactionToTransactionCommand) {
        this.transactionsRepository = transactionsRepository;
        this.transactionsCommandToTransaction = transactionsCommandToTransaction;
        this.transactionToTransactionCommand = transactionToTransactionCommand;
        this.accountService=accountService;
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
            if(transactionsCommand.getFromAccount()!=null){
                if((transactionsCommand.getFromAccount().getAccountNo().equals(accountNo))){
                    list.add(transactionsCommand);
                }
                else  if(transactionsCommand.getToAccount()!=null){
                    if((transactionsCommand.getToAccount().getAccountNo().equals(accountNo))){
                        list.add(transactionsCommand);
                    }
                }
            }
            else {
                if((transactionsCommand.getToAccount().getAccountNo().equals(accountNo))){
                    list.add(transactionsCommand);
                }
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
    public TransactionsCommand saveTransact(TransactionsCommand transactionsCommand) {
        Transactions transactions;
        transactions=transactionsRepository.save(transactionsCommandToTransaction.convert(transactionsCommand));
        return transactionToTransactionCommand.convert(transactions);
    }

    @Override
    public void deleteTransact(Long id) {
        transactionsRepository.deleteById(id);
    }

    @Override
    public TransactionsCommand makeTransact(TransactionsCommand transactionsCommand) {
        AccountCommand accountCommandFrom=new AccountCommand();
        AccountCommand accountCommandTo=new AccountCommand();
        TransactionsCommand transactionsCommand1Saved=new TransactionsCommand();
        int passCode=1;
        if(transactionsCommand.getFromAccount()!=null){
            accountCommandFrom=accountService.findAccount(transactionsCommand.getFromAccount().getAccountNo());
            if((accountCommandFrom.getBalance()-transactionsCommand.getAmount())>-1){
                accountCommandFrom.setBalance((accountCommandFrom.getBalance()-transactionsCommand.getAmount()));
                passCode=1;
                accountService.saveAccount(accountCommandFrom);
            }
            else {
                passCode=-1;
            }
        }
        if(transactionsCommand.getToAccount()!=null){
            accountCommandTo=accountService.findAccount(transactionsCommand.getToAccount().getAccountNo());
            if(passCode==1){
                accountCommandTo.setBalance((accountCommandTo.getBalance()+transactionsCommand.getAmount()));
                accountService.saveAccount(accountCommandTo);
                passCode=1;
            }
        }
        if (passCode==1){
            transactionsCommand1Saved=saveTransact(transactionsCommand);
                 }
        return transactionsCommand1Saved;
    }
}
