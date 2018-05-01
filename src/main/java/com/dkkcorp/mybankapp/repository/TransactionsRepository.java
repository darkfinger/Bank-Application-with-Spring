package com.dkkcorp.mybankapp.repository;

import com.dkkcorp.mybankapp.domain.Transactions;
import org.springframework.data.repository.CrudRepository;

public interface TransactionsRepository extends CrudRepository<Transactions,Long> {
}
