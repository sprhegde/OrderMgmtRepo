package com.ordermgmt.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermgmt.auth.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
