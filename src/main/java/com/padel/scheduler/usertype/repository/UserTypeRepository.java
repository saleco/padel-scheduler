package com.padel.scheduler.usertype.repository;

import com.padel.scheduler.usertype.model.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Integer> {
}
