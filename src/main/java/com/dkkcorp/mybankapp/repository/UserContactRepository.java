package com.dkkcorp.mybankapp.repository;

import com.dkkcorp.mybankapp.domain.UserContact;
import org.springframework.data.repository.CrudRepository;

public interface UserContactRepository extends CrudRepository<UserContact,Long> {
}
