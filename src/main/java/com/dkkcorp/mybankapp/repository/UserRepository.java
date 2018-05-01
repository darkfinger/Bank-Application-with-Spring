package com.dkkcorp.mybankapp.repository;

import com.dkkcorp.mybankapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
