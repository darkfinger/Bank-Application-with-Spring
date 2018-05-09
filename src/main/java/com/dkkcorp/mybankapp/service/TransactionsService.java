package com.dkkcorp.mybankapp.service;

import com.dkkcorp.mybankapp.command.TransactionsCommand;

import java.util.List;

public interface TransactionsService {

    TransactionsCommand findTransact(Long id);
    List<TransactionsCommand> findAllTransact();
    List<TransactionsCommand> findTransactByAccount(Long accountNo);
    List<TransactionsCommand> findTransactByUser(Long userId);
    TransactionsCommand saveTransact(Long id);
    void deleteTransact(Long id);
}
