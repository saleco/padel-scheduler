package com.padel.scheduler.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserType {

    @Id
    private Integer id;
    private String name;
}
