package com.dkkcorp.mybankapp.repository;

import com.dkkcorp.mybankapp.domain.UserAdmin;
import org.springframework.data.repository.CrudRepository;

public interface UserAdminRepository extends CrudRepository<UserAdmin,Long> {
}
