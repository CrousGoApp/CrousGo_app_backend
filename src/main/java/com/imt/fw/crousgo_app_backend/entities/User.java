package com.imt.fw.crousgo_app_backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name= "firstname")
    private String firstname;

    @Column(name= "lastname")
    private String lastname;
}
