package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProvisionProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer statusServiceProvider;

    @ManyToOne
    private Provider provider;

    @ManyToOne
    private Provision provision;
}
