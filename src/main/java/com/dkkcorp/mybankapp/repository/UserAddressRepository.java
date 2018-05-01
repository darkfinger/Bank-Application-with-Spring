package com.dkkcorp.mybankapp.repository;

import com.dkkcorp.mybankapp.domain.UserAddress;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<UserAddress,Long> {
}
