package com.be_casemd6.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Provision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    private Category category;
}
