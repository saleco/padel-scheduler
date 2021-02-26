package com.padel.scheduler.field.repository;

import com.padel.scheduler.field.model.Field;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends CrudRepository<Field, Integer> {
}
