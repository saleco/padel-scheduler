package com.padel.scheduler.repositories;

import com.padel.scheduler.model.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Integer> {
}
