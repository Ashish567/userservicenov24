package com.example.userservicenov24.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//test
public class Role extends BaseModel {
    private String value;
}
