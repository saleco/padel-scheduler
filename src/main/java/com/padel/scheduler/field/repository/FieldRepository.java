package com.padel.scheduler.field.repository;

import com.padel.scheduler.field.model.Field;
import com.padel.scheduler.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field, Integer> {
    List<Field> findAllByLocation(Location location);
}
