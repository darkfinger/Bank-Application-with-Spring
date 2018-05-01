package com.dkkcorp.mybankapp.repository;

import com.dkkcorp.mybankapp.domain.*;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,Long> {
}
