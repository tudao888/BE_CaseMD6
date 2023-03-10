package com.be_casemd6.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data

public class Role implements GrantedAuthority {
    @Id
    private int id;
    private String name;
    @Override
    public String getAuthority() {
        return name;
    }
}